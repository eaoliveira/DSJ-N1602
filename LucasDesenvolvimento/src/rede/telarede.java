package rede;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
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
public class telarede extends JFrame implements ActionListener, Runnable {

	private JPanel contentPane;
	private JTextField txtmsg;
	private JButton btnEnviar;
	private JScrollPane scrollPane;
	private JTextArea txtarea;
	private JButton btnConectar;
	private JButton btnDescnectar;
	private JButton btnSair;

	private Socket skt;
	private Thread chat;
	private PrintWriter out;
	private BufferedReader in;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telarede frame = new telarede();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public telarede() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenssagens = new JLabel("Mensagens :");
		lblMenssagens.setBounds(10, 11, 92, 16);
		contentPane.add(lblMenssagens);

		txtmsg = new JTextField();
		txtmsg.addActionListener(this);
		txtmsg.setBounds(93, 10, 200, 20);
		contentPane.add(txtmsg);
		txtmsg.setColumns(10);

		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(this);
		btnEnviar.setBounds(319, 6, 98, 26);
		contentPane.add(btnEnviar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 427, 162);
		contentPane.add(scrollPane);

		txtarea = new JTextArea();
		scrollPane.setViewportView(txtarea);

		btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(this);
		btnConectar.setBounds(34, 223, 98, 26);
		contentPane.add(btnConectar);

		btnDescnectar = new JButton("Descnectar");
		btnDescnectar.addActionListener(this);
		btnDescnectar.setBounds(166, 223, 114, 26);
		contentPane.add(btnDescnectar);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(314, 223, 98, 26);
		contentPane.add(btnSair);
	}

	public void actionPerformed(ActionEvent ev) {

		Object botao = ev.getSource();
		try {
			if (botao.equals(btnConectar)) {
				skt = new Socket("localhost", 1234);

				out = new PrintWriter(skt.getOutputStream());
				in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
				chat = new Thread(this);
				chat.start();
				txtarea.requestFocus();
				getRootPane().setDefaultButton(btnEnviar);
			} else if (botao.equals(btnEnviar)) {
					String txt = txtmsg.getText();
					out.println(txt);
					out.flush();
					txtmsg.setText("");
					txtmsg.requestFocus();
			}else  if (botao.equals(btnDescnectar)) {
				out.println("SAIR");
				out.flush();
				chat.interrupt();
				skt.close();
				getRootPane().setDefaultButton(btnConectar);
			} else {
				System.exit(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void run() {
		try {
			while (!chat.isInterrupted()) {
				if(in.ready())
					txtarea.append("Escreveu: " + in.readLine() + "\n");
				Thread.sleep(100);
			}
		} catch (Exception ex) {
		}
	}

}
