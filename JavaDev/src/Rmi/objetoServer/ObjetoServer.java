package Rmi.objetoServer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ObjetoServer extends UnicastRemoteObject 
		implements ActionListener, ObjetoInterface	 {
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnLimpar;
	private JButton btnSair;
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.setProperty("java.net.preferIPv4Stack", "true");
					Registry reg = LocateRegistry.createRegistry(1099);

					ObjetoServer frame = new ObjetoServer();
					
					reg.rebind("telaSwing", frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ObjetoServer() throws RemoteException {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 438, 216);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(this);
		btnLimpar.setBounds(65, 234, 117, 29);
		contentPane.add(btnLimpar);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(279, 234, 117, 29);
		contentPane.add(btnSair);
		
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ev) {
		String cmd = ev.getActionCommand();
		
		if(cmd.equals("Limpar")) {
			textArea.setText("");
		} else {
			System.exit(0);
		}	
	}

	public void salva(Object obj)  throws RemoteException {
		textArea.append(obj.toString() + 
				"\n---------------------------------\n");
	}
}
