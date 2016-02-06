package SocketsBatePapoCopy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.*;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class Usuario extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JLabel lblNome;
	private JTextField tfMsg;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panel;
	private JLabel status;
	private JMenuBar menuBar;
	private JMenu mnAcoes;
	private JMenuItem mntmConectar;
	private JMenuItem mntmDesconectar;
	private JSeparator separator;
	private JMenuItem mntmSair;

	// Decleraçãod de Variáveis
	Socket skt;
	BufferedReader in;
	PrintWriter out;
	Thread aThr;

	public static void main(String[] args) {
		EventQueue.invokeLater(Usuario::new);
	}

	public Usuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 309);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnAcoes = new JMenu("Ações");
		menuBar.add(mnAcoes);

		mntmConectar = new JMenuItem("Conectar");
		mntmConectar.addActionListener(this);
		mnAcoes.add(mntmConectar);

		mntmDesconectar = new JMenuItem("Desconectar");
		mntmDesconectar.setEnabled(false);
		mntmDesconectar.addActionListener(this);
		mnAcoes.add(mntmDesconectar);

		separator = new JSeparator();
		mnAcoes.add(separator);

		mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(this);
		mnAcoes.add(mntmSair);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblNome = new JLabel("Mensagem");

		tfMsg = new JTextField();
		tfMsg.setEditable(false);
		tfMsg.addActionListener(this);
		tfMsg.setColumns(10);

		scrollPane = new JScrollPane();

		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNome)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(tfMsg,
														GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)).addGap(11))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNome).addComponent(
						tfMsg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE).addGap(9)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)));

		status = new JLabel("");
		panel.add(status);

		// Configura o posicionamento automático do cursor no textArea quando uma mensagem for inserida
		scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent ev) {
				textArea.setCaretPosition(textArea.getText().length());
			}
		});

		textArea = new JTextArea();
		textArea.setFocusable(false);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ev) {
		Object selecao = ev.getSource();

		if (selecao.equals(tfMsg)) {
			// mandar a mensagem
			String msg = tfMsg.getText();

			// envia a mensagem
			out.println(msg);
			out.flush();

			// após mandar a mensagem
			tfMsg.setText("");
		} else if (selecao.equals(mntmConectar)) {

			try {
				// skt = new Socket("10.84.144.250", 1234);
				skt = new Socket("127.0.0.1", 1234);
				in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
				out = new PrintWriter(skt.getOutputStream());

				aThr = new classThread();
				aThr.start();

				status.setText("Conectado");

			} catch (IOException e) {
				status.setText("Erro: " + e.getMessage());
			}

			// após a conexão
			mntmConectar.setEnabled(false);
			mntmSair.setEnabled(false);
			mntmDesconectar.setEnabled(true);
			tfMsg.setEditable(true);
		} else if (selecao.equals(mntmDesconectar)) {

			try {
				// Saindo do Servidor
				out.println("SAIR");
				out.flush();

				// finaliza a thread
				aThr.interrupt();

				// finaliza a conexão
				skt.close();

				// Avisa o usuário que vai sair
				status.setText("Desconectado!");
			} catch (IOException e) {
				status.setText("Erro: " + e.getMessage());
			}

			mntmConectar.setEnabled(true);
			mntmSair.setEnabled(true);
			mntmDesconectar.setEnabled(false);
			tfMsg.setEditable(false);
		} else { // Sair
			System.exit(0);
		}
	}

	class classThread extends Thread {
		public void run() {
			try {
				while (!isInterrupted()) {
					if (!in.ready()) {
						// iniciar a theard
						textArea.append(in.readLine() + "\n");
					}
					sleep(100);
				}
			} catch (IOException ex) {
				if (!skt.isClosed()) {
					status.setText("Erro: " + ex.getMessage());
					// status.setText("Erro ao ler mensagens");
				}
			} catch (InterruptedException ex) {
				status.setText("Leitor finalizado");
			}
		}

	}
}
