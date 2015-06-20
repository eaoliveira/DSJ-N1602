package Rede.outros.cliente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaMsg extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblM;
	private JTextField tfMensagem;
	private JButton btnEnviar;
	private JScrollPane scrollPane;
	private JTextArea tfMensagens;
	private JButton btnConetar;
	private JButton btnDesconectar;
	private JButton btnSair;
	BufferedReader in = null;
	PrintWriter out = null;
	Thread thread;
	Socket skt = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMsg frame = new TelaMsg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaMsg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblM = new JLabel("Mensagem");
		lblM.setBounds(10, 22, 60, 14);
		contentPane.add(lblM);

		tfMensagem = new JTextField();
		tfMensagem.setBounds(67, 19, 243, 20);
		contentPane.add(tfMensagem);
		tfMensagem.setColumns(10);

		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(this);
		btnEnviar.setBounds(320, 18, 89, 23);
		contentPane.add(btnEnviar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 399, 167);
		contentPane.add(scrollPane);

		tfMensagens = new JTextArea();
		scrollPane.setViewportView(tfMensagens);
		tfMensagens.setColumns(10);

		btnConetar = new JButton("Conectar");
		btnConetar.addActionListener(this);
		btnConetar.setBounds(34, 227, 89, 23);
		contentPane.add(btnConetar);

		btnDesconectar = new JButton("Desconectar");
		btnDesconectar.addActionListener(this);
		btnDesconectar.setBounds(157, 227, 117, 23);
		contentPane.add(btnDesconectar);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(308, 227, 89, 23);
		contentPane.add(btnSair);

		getRootPane().setDefaultButton(btnEnviar);
		
		
		btnEnviar.setEnabled(false);
		btnDesconectar.setEnabled(false);
		tfMensagem.setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {

		Object botao = e.getSource();

		try {
			if (botao.equals(btnConetar)) {
				// Estabelecendo conexão com o servidor
				skt = new Socket("localhost", 12345);

				out = new PrintWriter(skt.getOutputStream());
				in = new BufferedReader(new InputStreamReader(
						skt.getInputStream()));

				thread = new AtualizaMsg();
				thread.start();
				btnEnviar.setEnabled(true);
				btnDesconectar.setEnabled(true);
				btnConetar.setEnabled(false);
				btnSair.setEnabled(false);
				tfMensagem.requestFocus();
				tfMensagem.setEnabled(true);
			} else if (botao.equals(btnDesconectar)) {
				out.println("Saiu da sala");
				out.flush();
				out.println("SAIR");
				out.flush();
				
				thread.interrupt();
				out.close();
				skt.close();
				btnEnviar.setEnabled(false);
				btnDesconectar.setEnabled(false);
				btnConetar.setEnabled(true);
				btnSair.setEnabled(true);
				tfMensagem.setEnabled(false);
			} else if (botao.equals(btnEnviar)) {
				String txt = tfMensagem.getText();
				
				out.println(txt);
				out.flush();
				tfMensagem.setText("");
				tfMensagem.requestFocus();
			} else {
				System.exit(0);
			}
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	class AtualizaMsg extends Thread {
		@Override
		public void run() {
			while (!isInterrupted()) {
				try {
					if(in.ready())
						tfMensagens.append(in.readLine() + "\n");
					Thread.sleep(100);
				} catch (InterruptedException | IOException e) {
					//e.printStackTrace();
				}
			}
		}
	}
}
