package rede;

import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ChatOnServidor extends JFrame implements ActionListener, Runnable {

	private JPanel contentPane;
	private JLabel lblMensagem;
	private JTextField tfMensagem;
	private JButton btnEnviar;
	private JScrollPane scrollPane;
	private JTextArea tfConsole;
	private JButton btnConectar;
	private JButton btnDesconectar;
	private JButton btnSair;
	private Socket skt;
	private PrintWriter out;
	private BufferedReader in;
	private Thread th;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (Throwable ex) {
					ex.printStackTrace();
				}

				try {
					ChatOnServidor frame = new ChatOnServidor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChatOnServidor() {
		setResizable(false);
		setTitle("Chat-on");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblMensagem = new JLabel("Mensagem");
		lblMensagem.setBounds(15, 20, 51, 14);

		tfMensagem = new JTextField();
		tfMensagem.setBounds(76, 17, 290, 20);
		tfMensagem.setColumns(10);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setMnemonic('e');
		btnEnviar.setBounds(384, 16, 63, 23);
		btnEnviar.addActionListener(this);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 57, 432, 217);

		btnConectar = new JButton("Conectar");
		btnConectar.setBounds(15, 292, 77, 23);
		btnConectar.addActionListener(this);

		btnDesconectar = new JButton("Desconectar");
		btnDesconectar.setBounds(102, 292, 93, 23);
		btnDesconectar.addActionListener(this);

		btnSair = new JButton("Sair");
		btnSair.setBounds(396, 292, 51, 23);
		btnSair.addActionListener(this);
		contentPane.setLayout(null);

		tfConsole = new JTextArea();
		tfConsole.setLineWrap(true);
		tfConsole.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(tfConsole);
		contentPane.add(scrollPane);
		contentPane.add(lblMensagem);
		contentPane.add(tfMensagem);
		contentPane.add(btnEnviar);
		contentPane.add(btnConectar);
		contentPane.add(btnDesconectar);
		contentPane.add(btnSair);

		this.setLocationRelativeTo(null);
		btnEnviar.setEnabled(false);
		btnDesconectar.setEnabled(false);
		tfConsole.setEditable(false);
	}

	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();

		try {

			if (botao.equals(btnConectar)) {
					
					skt = new Socket("localhost", 1234);

					out = new PrintWriter(skt.getOutputStream());
					in = new BufferedReader(new InputStreamReader(
							skt.getInputStream()));

					tfConsole.append(in.readLine() + "\n\n");
					tfMensagem.requestFocus();

					th = new Thread(this);
					th.start();
					
					btnConectar.setEnabled(false);
					btnEnviar.setEnabled(true);
					btnDesconectar.setEnabled(true);
		
					
			} else if (botao.equals(btnDesconectar)) {
				
				out.println("A99652871");
				out.flush();

				th.interrupt();
				skt.close();

				tfConsole.append("Desconectado\n------------------------\n");
				tfMensagem.requestFocus();
				
				btnConectar.setEnabled(true);
				btnEnviar.setEnabled(false);
				btnDesconectar.setEnabled(false);

			} else if (botao.equals(btnEnviar)) {
		
					String mensagem = "";
					mensagem = tfMensagem.getText();
					out.println(mensagem);
					out.flush();

					tfMensagem.setText("");
					tfMensagem.requestFocus();
				

			} else {
				System.exit(0);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
			ex.getMessage();
		} 

	}

	@Override
	public void run() {

		try {

			while (!th.isInterrupted()) {
				
				tfConsole.append(in.readLine() + "\n");
				
			}

		} catch (IOException ex) {
			ex.printStackTrace();
			ex.getMessage();
		}

	}

}
