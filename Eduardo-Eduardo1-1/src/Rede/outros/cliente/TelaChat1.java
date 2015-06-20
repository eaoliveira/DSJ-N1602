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
public class TelaChat1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tfMensagem;
	private JButton btEnviar;
	private JScrollPane scrollPane;
	private JTextArea taMensagem;
	private JButton btConectar;
	private JButton btDesconectar;
	private JButton btSair;

	RecebeMensagem recebeMensagem;

	Thread tInput, tOut, tConexao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaChat1 frame = new TelaChat1();
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
	public TelaChat1() {

		// this.recebeMensagem = new RecebeMensagem(taMensagem);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Mensagem:");
		lblNewLabel.setBounds(10, 11, 78, 23);
		contentPane.add(lblNewLabel);

		tfMensagem = new JTextField();
		tfMensagem.setBounds(98, 12, 227, 20);
		contentPane.add(tfMensagem);
		tfMensagem.setColumns(10);

		btEnviar = new JButton("Enviar");
		btEnviar.addActionListener(this);
		btEnviar.setBounds(335, 11, 89, 23);
		contentPane.add(btEnviar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 414, 167);
		contentPane.add(scrollPane);

		taMensagem = new JTextArea();
		scrollPane.setViewportView(taMensagem);

		btConectar = new JButton("Conectar");
		btConectar.addActionListener(this);
		btConectar.setBounds(10, 218, 89, 23);
		contentPane.add(btConectar);

		btDesconectar = new JButton("Desconectar");
		btDesconectar.addActionListener(this);
		btDesconectar.setBounds(166, 218, 114, 23);
		contentPane.add(btDesconectar);

		btSair = new JButton("Sair");
		btSair.addActionListener(this);
		btSair.setBounds(335, 218, 89, 23);
		contentPane.add(btSair);

		taMensagem.setEditable(false);
		ativarBotao(false);
	}

	public void actionPerformed(ActionEvent e) {
		Object botao = e.getSource();
		if (botao.equals(btConectar)) {
			recebeMensagem = new RecebeMensagem();
			ativarBotao(true);
		} else if (botao.equals(btEnviar)) {
			recebeMensagem.enviar(tfMensagem.getText());
			tfMensagem.setText("");
			tfMensagem.requestFocus();
		} else if (botao.equals(btDesconectar)) {
			recebeMensagem.fechar();
			ativarBotao(false);
		} else {
			System.exit(0);
		}
	}

	public void ativarBotao(boolean flag) {
		tfMensagem.setEnabled(flag);
		btEnviar.setEnabled(flag);
		btConectar.setEnabled(!flag);
		btSair.setEnabled(!flag);
		btDesconectar.setEnabled(flag);
		if(flag) {
			getRootPane().setDefaultButton(btEnviar);
			tfMensagem.requestFocus();
		} else
			getRootPane().setDefaultButton(btConectar);
	}
	
	class RecebeMensagem implements Runnable {
		PrintWriter enviaMensagem;
		BufferedReader recebe;
		Socket socket;
		Thread tred;

		public RecebeMensagem() {
			try {
				// Estabelecendo conex√£o com o servidor
				socket = new Socket("10.84.144.250", 1234);

				// Obtendo os canais de Entrada e Saida
				enviaMensagem = new PrintWriter(socket.getOutputStream());

				// Input Stream associado a console
				recebe = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));

				tred = new Thread(this);
				tred.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void enviar(String txt) {
			if (enviaMensagem != null) {
				enviaMensagem.println(txt);
				enviaMensagem.flush();
			} else {
				throw new RuntimeException("A inst‚ncia de RecebeMensage deve ser reinicializada");
			}
		}

		public void fechar() {
			try {
				if (tred != null) {
					tred.interrupt();
					socket.close();
				} else {
					throw new RuntimeException("A inst‚ncia de RecebeMensage deve ser reinicializada");
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (!tred.isInterrupted()) {
				try {
					if (recebe.ready())
						taMensagem.append(recebe.readLine() + "\n");
					Thread.sleep(100);
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch(InterruptedException e) {
				}
			}
		}

	}

}
