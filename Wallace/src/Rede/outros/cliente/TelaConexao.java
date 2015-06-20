package Rede.outros.cliente;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TelaConexao extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtMENSAGEM;
	private JButton btnEnviar, btnConectar, btnDesconectar;
	private JButton btnSair;
	private JTextArea txtAchat;
	private Socket skt;
	private PrintWriter out;
	private BufferedReader in;
	private Thread LerMsg;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConexao frame = new TelaConexao();
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
	public TelaConexao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtMENSAGEM = new JTextField();
		txtMENSAGEM.setBounds(135, 22, 305, 27);
		contentPane.add(txtMENSAGEM);
		txtMENSAGEM.setColumns(10);

		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(this);
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnviar.setBounds(465, 22, 89, 27);
		contentPane.add(btnEnviar);

		JLabel lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMensagem.setBounds(32, 22, 108, 21);
		contentPane.add(lblMensagem);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 93, 500, 200);
		contentPane.add(scrollPane);

		txtAchat = new JTextArea();
		scrollPane.setViewportView(txtAchat);

		btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(this);
		btnConectar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConectar.setBounds(32, 327, 108, 27);
		contentPane.add(btnConectar);

		btnDesconectar = new JButton("Desconectar");
		btnDesconectar.addActionListener(this);
		btnDesconectar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDesconectar.setBounds(213, 327, 141, 27);
		contentPane.add(btnDesconectar);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSair.setBounds(424, 327, 108, 27);
		contentPane.add(btnSair);

		getRootPane().setDefaultButton(btnEnviar);
	}

	@Override
	public void actionPerformed(ActionEvent ev){
		Object botao = ev.getSource();

		try {
			if (botao.equals(btnConectar)) {
				skt = new Socket("127.0.0.1", 1234);
				in = new BufferedReader(new InputStreamReader(
						skt.getInputStream()));
				// canal de saida

				// iniciar a thread que le mensagens
				out = new PrintWriter(skt.getOutputStream());
				LerMsg = new Lermsg();
				LerMsg.start();
			} else if (botao.equals(btnDesconectar)) {
				out.println("SAIR");
				out.flush();
				// parar a thread que le mensagens
				LerMsg.interrupt();
				// enviar a mensagem SAIR para o servidor poder finalizar o
				// proprio Socket
				// fechar o socket
				skt.close();
			} else if (botao.equals(btnEnviar)) {
				// enviar o text atraves do socke
				String txt = txtMENSAGEM.getText();
				out.println(txt);
				out.flush();
				txtMENSAGEM.setText("");
				txtMENSAGEM.requestFocus();
			} else {
				// fechar a tela
				System.exit(0);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public class Lermsg extends Thread {
		@Override
		public void run() {
			try {
				while (!isInterrupted()) {
					//System.out.println("O chat esta funcionando");
					if (in.ready()) {
						txtAchat.append(in.readLine() + "\n");
					}
					Thread.sleep(300);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
