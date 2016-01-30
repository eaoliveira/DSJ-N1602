package Rede.exemplos;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class AcessoHtml extends JFrame implements ActionListener {
	protected String host;
	protected String file;
	protected int port;
	protected BufferedReader in;
	protected DataOutputStream out;
	
	private JLabel lblUrl = new JLabel("URL:");
	private JTextField tfUrl = new JTextField(10);
	private JButton btEnviar = new JButton("Enviar");
	private JLabel status = new JLabel();
	private JTextArea pagina = new JTextArea();

	public AcessoHtml() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		criaTela();
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		try {
			Socket socket = null;
			validaURL(tfUrl.getText());
			socket = connect();

			try {
				acessa();
			} finally {
				socket.close();
			}
		} catch(MalformedURLException ex) {
			status.setText("URL Inválida");
		} catch (IOException ex) {
			status.setText("Falha em Conectar");
		}
	}

	private void criaTela() {
		setPreferredSize(new Dimension(514,309));
		setMinimumSize(new Dimension(514,309));
		JPanel panel = new JPanel();		
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUrl)
							.addGap(18)
							.addComponent(tfUrl, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btEnviar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
							.addGap(2)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUrl)
						.addComponent(tfUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btEnviar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		tfUrl.addActionListener(this);
		btEnviar.addActionListener(this);
		
		pagina.setFocusable(false);
		pagina.setEditable(false);
		scrollPane.setViewportView(pagina);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		status.setFocusable(false);
		panel.add(status);
		getContentPane().setLayout(groupLayout);
		
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}
	
	// Valida o endereço de acesso à informação
	protected void validaURL(String textURL) throws MalformedURLException {
		URL url = new URL(textURL);
		host = url.getHost();
		port = url.getPort();

		if (port == -1)
			port = 80;

		file = url.getFile();
	}

	protected Socket connect() throws IOException {
		status.setText("Conectando a " + host + ":" + port + "..");
		// Conecta ao servidar na porta informada
		Socket socket = new Socket(host, port);
		status.setText("Conectado.");

		// obtem os canais ne leitura e gravação
		OutputStream rawOut = socket.getOutputStream();
		InputStream rawIn = socket.getInputStream();
		
		// configurando uma área para armazenamento temporário dos
		// dados de saída
		BufferedOutputStream buffOut = new BufferedOutputStream(rawOut);
		out = new DataOutputStream(buffOut);
		
		// configurando uma área para armazenamento temporário dos
		// dados de entrada
		in = new BufferedReader(new InputStreamReader(rawIn));

		return socket;
	}

	protected void acessa() throws IOException {
		status.setText("Enviando a requisição..");

		out.writeBytes("GET " + file + " HTTP/1.0\r\n\r\n");
		out.flush();

		status.setText("Aguardando pela resposta..");

		String input;
		while ((input = in.readLine()) != null)
			pagina.append(input + "\n");
		status.setText("Ok");
	}

	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(AcessoHtml::new);
	}
}
