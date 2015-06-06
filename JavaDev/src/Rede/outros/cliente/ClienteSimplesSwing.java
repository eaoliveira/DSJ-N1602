package Rede.outros.cliente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ClienteSimplesSwing extends JFrame implements ActionListener {
	private JTextArea ta = new JTextArea(10, 20);
	private JTextField tfMens = new JTextField(10);
	private JMenuItem mnConn = new JMenuItem("Conectar");
	private JMenuItem mnSair = new JMenuItem("Sair");
	private Socket s = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private Thread leitor = null;

	public ClienteSimplesSwing() {
		setTitle("Chat 1/2 Boca");
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		JMenu menu = new JMenu("Iniciar");
		bar.add(menu);
		mnConn.addActionListener(this);
		menu.add(mnConn);
		menu.addSeparator();
		mnSair.setEnabled(false);
		mnSair.addActionListener(this);
		menu.add(mnSair);
		
		tfMens.addActionListener(this);
		tfMens.setActionCommand("enviar");
		JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 5));
		painel.add(new JLabel("Mensagem"));
		painel.add(tfMens);
		add(painel, BorderLayout.NORTH);
		
		ta.setEditable(false);
		JPanel painel2 = new JPanel(new GridLayout(1,1));
		painel2.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
		painel2.add(new JScrollPane(ta));
		add(painel2, BorderLayout.CENTER);
		
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ev) {
		String cmd = ev.getActionCommand();
		
		try {
			if(cmd.equals("Conectar")) {
				s = new Socket("localhost", 1234);
				InputStreamReader is = new InputStreamReader(s.getInputStream());
				in = new BufferedReader(is);
				out = new PrintWriter(s.getOutputStream());
				mnConn.setEnabled(false);
				mnSair .setEnabled(true);
				
				// iniciar a Thread de Leitura do Socket
				leitor = new Thread() {
					public void run() {
						try {
							while (!isInterrupted()) {
								while(in.ready()) {
									String txt = in.readLine();
									ta.append(txt+ "\n");
								}
							}
						}catch(Exception ex) {}
					}
				};
				leitor.start();
			
			} else if(cmd.equals("enviar")) {
				String txt = tfMens.getText();
				out.println(txt);
				out.flush();
				tfMens.setText("");
				tfMens.requestFocus();
				
			} else { // Sair
				leitor.interrupt();
				leitor.join();
				s.close();
				JOptionPane.showMessageDialog(this, "Conexão finalizada");
				System.exit(0);
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, "Erro durante a conexão: " + ex.getMessage());
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ClienteSimplesSwing();
	}
}
