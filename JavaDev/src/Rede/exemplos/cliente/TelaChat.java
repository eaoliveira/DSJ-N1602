package Rede.exemplos.cliente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaChat extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JLabel lblMensagem;
	private JTextField tfMsg;
	private JButton btnEnviar;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnConectar;
	private JButton btnDesconectar;
	private JButton btnSair;

	private Socket skt;
	private BufferedReader in;
	private PrintWriter out;
	private Thread leitor;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
				try {
					TelaChat frame = new TelaChat();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
	}

	public TelaChat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblMensagem = new JLabel("Mensagem");
		
		tfMsg = new JTextField();
		tfMsg.setEnabled(false);
		tfMsg.setActionCommand("Enviar");
		tfMsg.addActionListener(this);
		tfMsg.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setEnabled(false);
		btnEnviar.addActionListener(this);
		
		scrollPane = new JScrollPane();
		
		btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(this);
		
		btnDesconectar = new JButton("Desconectar");
		btnDesconectar.setEnabled(false);
		btnDesconectar.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMensagem)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfMsg, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnEnviar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
							.addGap(1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnConectar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addComponent(btnDesconectar)
							.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMensagem)
						.addComponent(tfMsg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEnviar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConectar)
						.addComponent(btnDesconectar)
						.addComponent(btnSair))
					.addContainerGap())
		);
		
		textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setFocusable(false);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void actionPerformed(ActionEvent ev) {
		Object opcao = ev.getSource();
		
		try {
			if(opcao.equals(tfMsg) || opcao.equals(btnEnviar)) {
				out.println(tfMsg.getText());
				out.flush();
				tfMsg.setText("");
			} else if(opcao.equals(btnConectar)) {
				// conectando no servidor
				skt = new Socket("10.84.144.250", 1234);
				// Obtendo o canal de leitura do socket
				in = new BufferedReader( new InputStreamReader( skt.getInputStream() ) );
				// Obtendo o canal de gravação do socket
				out = new PrintWriter(skt.getOutputStream());
				// Inicializa a rotina de leitura
				textArea.setText("");
				leitor = new Thread() {
					public void run() {
						try {
							while (!interrupted()) {
								if(in.ready()) {
									textArea.append(in.readLine() + "\n");
									textArea.setCaretPosition(textArea.getText().length());
								} else {
									sleep(5);
								}
							}
						} catch(Exception ex) {}
					}
				};
				leitor.start();
				conectado(true);
				tfMsg.requestFocus();
			} else if(opcao.equals(btnDesconectar)) {
				out.println("SAIR");
				out.flush();
				leitor.interrupt();
				skt.close();
				conectado(false);
			} else {
				System.exit(0);
			}
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(this, "Problemas no envio da mensagem");
		}
	}
	
	private void conectado(boolean valor) {
		tfMsg.setEnabled(valor);
		btnEnviar.setEnabled(valor);
		btnConectar.setEnabled(!valor);
		btnDesconectar.setEnabled(valor);
		btnSair.setEnabled(!valor);
	}
}

