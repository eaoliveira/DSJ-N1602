package Rede.abs;

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
public class TelaCliente extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JLabel lblMensagem;
	private JTextField tfMsg;
	private JButton btnEnviar;
	private JScrollPane scrollPane;
	private JButton btnConectar;
	private JTextArea textArea;
	private JButton btnDesconectar;
	private JButton btnSair;

	private Socket sckt;
	private BufferedReader in;
	private PrintWriter out;
	private Thread leitor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMensagem = new JLabel("Mensagem");
		lblMensagem.setBounds(19, 21, 78, 16);
		contentPane.add(lblMensagem);

		tfMsg = new JTextField();
		tfMsg.setEnabled(false);
		tfMsg.addActionListener(this);
		tfMsg.setBounds(109, 20, 253, 19);
		contentPane.add(tfMsg);
		tfMsg.setColumns(10);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setEnabled(false);
		btnEnviar.addActionListener(this);
		btnEnviar.setBounds(380, 17, 78, 25);
		contentPane.add(btnEnviar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 49, 446, 179);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(this);
		btnConectar.setBounds(19, 253, 106, 25);
		contentPane.add(btnConectar);

		btnDesconectar = new JButton("Desconectar");
		btnDesconectar.setEnabled(false);
		btnDesconectar.addActionListener(this);
		btnDesconectar.setBounds(178, 253, 128, 25);
		contentPane.add(btnDesconectar);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(359, 253, 106, 25);
		contentPane.add(btnSair);
	}

	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();

		try {

			if (botao.equals(btnConectar)) {
				// Cria um Socket e abre uma conexão a um servidor
				sckt = new Socket("localhost", 1234);
				// Cria um Leitor para o Socket
				in = new BufferedReader(new InputStreamReader(
						sckt.getInputStream()));
				// Cria um Gravador para o Socket
				out = new PrintWriter(sckt.getOutputStream());

				tfMsg.setEnabled(true);
				btnEnviar.setEnabled(true);
				btnDesconectar.setEnabled(true);
				btnConectar.setEnabled(false);
				
				leitor = new Thread() {
					public void run() {
						while (!interrupted()) {
							try {
								while (in.ready()) {
									// Lê o texto do Servidor
									String txt = in.readLine();
									// Grava na console do cliente
									textArea.append(txt + "\n");
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				};
				leitor.start();
			} else if (botao.equals(btnDesconectar)) {
				leitor.interrupt();
				sckt.close();

				tfMsg.setEditable(false);
				btnEnviar.setEnabled(false);
				btnDesconectar.setEnabled(false);
				btnConectar.setEnabled(true);
			} else if (botao.equals(btnEnviar) || botao.equals(tfMsg)) {
				out.println(tfMsg.getText());
				out.flush();

				tfMsg.setText("");
			} else {
				if(sckt != null && !sckt.isClosed()) {
					leitor.interrupt();
					sckt.close();
				}
				System.exit(0);
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, "Erro no acesso ao servidor");
		}
	}
}
