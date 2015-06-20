package Rede.outros.cliente;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Tela extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField textFieldMsg;
	private JButton btnConectar;
	private JButton btnDesconectar;
	private JButton btnSair;
	private JButton btnEnviar;
	private JTextArea textArea;
	private Socket skt;
	private PrintWriter out;
	private BufferedReader in;
	private Thread thread;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tela() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblMensagem = new JLabel("Mensagem");
		lblMensagem.setBounds(31, 22, 98, 16);

		textFieldMsg = new JTextField();
		textFieldMsg.setBounds(158, 20, 254, 20);
		textFieldMsg.setColumns(10);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(450, 17, 69, 26);
		btnEnviar.addActionListener(this);

		btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(this);
		btnConectar.setBounds(38, 264, 86, 26);

		btnDesconectar = new JButton("Desconectar");
		btnDesconectar.addActionListener(this);
		btnDesconectar.setBounds(217, 264, 107, 26);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(450, 264, 57, 26);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 71, 488, 167);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(null);
		contentPane.add(btnConectar);
		contentPane.add(btnDesconectar);
		contentPane.add(btnSair);
		contentPane.add(lblMensagem);
		contentPane.add(textFieldMsg);
		contentPane.add(btnEnviar);
		contentPane.add(scrollPane);

		textArea.setEditable(false);
		textFieldMsg.setEnabled(false);
		btnEnviar.setEnabled(false);
		btnConectar.setEnabled(true);
		btnDesconectar.setEnabled(false);
		btnSair.setEnabled(true);
		getRootPane().setDefaultButton(btnConectar);// botao habilitado por
													// default
	}

	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();

		try {
			if (botao.equals(btnConectar)) {
				skt = new Socket("10.84.144.250", 1234);
				// iniciar os canais de entrada (in) e saida (out)
				out = new PrintWriter(skt.getOutputStream());
				in = new BufferedReader(new InputStreamReader(
						skt.getInputStream()));

				// iniciar um Thread de leitura de mensagens
				thread = new Leitor();
				thread.start();
				textFieldMsg.requestFocus();
				textFieldMsg.setEnabled(true);
				btnEnviar.setEnabled(true);
				btnConectar.setEnabled(false);
				btnDesconectar.setEnabled(true);
				btnSair.setEnabled(false);
				getRootPane().setDefaultButton(btnEnviar);
			} else if (botao.equals(btnEnviar)) {
				// enviar a mensagem para o servidor
				String txt = textFieldMsg.getText();

				out.println(txt);
				out.flush();

				textFieldMsg.setText("");
				textFieldMsg.requestFocus();
			} else if (botao.equals(btnDesconectar)) {
				// parar a Thread de leitura de mensagens
				thread.interrupt();
				// fechar o socket
				skt.close();
				textFieldMsg.setEnabled(false);
				btnEnviar.setEnabled(false);
				btnConectar.setEnabled(true);
				btnDesconectar.setEnabled(false);
				btnSair.setEnabled(true);
				getRootPane().setDefaultButton(btnConectar);
			} else { // Sair
				System.exit(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	class Leitor extends Thread {
		public void run() {
			try {
				while (!isInterrupted()) {
					if (in.ready()) {
						String txt = in.readLine();
						textArea.append(txt + "\n");
					}
					Thread.sleep(100);
				}
			} catch (InterruptedException | IOException e) {
			}
		}
	}
}
