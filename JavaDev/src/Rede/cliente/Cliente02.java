package Rede.cliente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Cliente02 extends JFrame implements ActionListener, Runnable {

	private JPanel contentPane;
	private JLabel lblMensagem;
	private JTextField tfMens;
	private JButton btnEnviar;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnConectar;
	private JButton btnDesconetar;
	private JButton btnSair;
	private Socket skt;
	private BufferedReader in;
	private PrintWriter out;
	private Thread thread; 

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente02 frame = new Cliente02();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Cliente02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMensagem = new JLabel("Mensagem");
		lblMensagem.setBounds(30, 34, 75, 16);
		contentPane.add(lblMensagem);

		tfMens = new JTextField();
		tfMens.setEnabled(false);
		tfMens.setBounds(116, 28, 241, 28);
		contentPane.add(tfMens);
		tfMens.setColumns(10);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setEnabled(false);
		btnEnviar.addActionListener(this);
		btnEnviar.setBounds(369, 29, 75, 29);
		contentPane.add(btnEnviar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 74, 403, 150);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		textArea.setEnabled(false);
		scrollPane.setViewportView(textArea);

		btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(this);
		btnConectar.setBounds(24, 236, 117, 29);
		contentPane.add(btnConectar);

		btnDesconetar = new JButton("Desconectar");
		btnDesconetar.setEnabled(false);
		btnDesconetar.addActionListener(this);
		btnDesconetar.setBounds(165, 236, 117, 29);
		contentPane.add(btnDesconetar);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(306, 236, 117, 29);
		contentPane.add(btnSair);

		getRootPane().setDefaultButton(btnEnviar);
	}

	public void actionPerformed(ActionEvent ev) {
		String cmd = ev.getActionCommand();

		try {
			if (cmd.equals("Conectar")) {
				skt = new Socket("localhost", 1234);
				in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
				out = new PrintWriter(skt.getOutputStream());
				
				// inicia a Thread de leitura dos dados do input Stream
				thread = new Thread(this);   
				thread.start();
   
			    btnConectar.setEnabled(false);
			    btnDesconetar.setEnabled(true);
			    btnEnviar.setEnabled(true);
			    tfMens.setEnabled(true);
			    tfMens.requestFocus();
			} else if (cmd.equals("Enviar")) {
		        out.println(tfMens.getText());
		        out.flush();
		        		        
		        tfMens.setText("");
		        tfMens.requestFocus();
			} else if(cmd.equals("Desconectar")){
				out.println("SAIR");
				out.flush();		    
				
				// Solicita a finalização da Thread
				thread.interrupt();
				// Aguarda pela finalização da Thread
				thread.join();
				
		        skt.close();
		        
			    btnConectar.setEnabled(true);
			    btnDesconetar.setEnabled(false);
			    btnEnviar.setEnabled(false);
			    tfMens.setEnabled(false);
			    btnConectar.requestFocus();
			} else {
				System.exit(0);
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this,
					"Problemas com o acesso ao servidor");
			ex.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void run() {
		// Executa a leitura do input Stream 
		// enquanto a thread não recebeu solicitação
		// para ser interrompida
		while(!thread.isInterrupted()) {
	        try {
	        	    // Lê o input Stream e grava no TextArea
				textArea.append(in.readLine()+"\n");
				// posiciona o cursor no final do texto para
				// que a informação mais recente sempre
				// esteja presente na tela
				textArea.setCaretPosition(textArea.getText().length());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
