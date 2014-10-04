package Rmi.objetoServer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
		
		scrollPane = new JScrollPane();
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
	        public void adjustmentValueChanged(AdjustmentEvent e) {
	        	textArea.setCaretPosition(textArea.getText().length());
	        }
	      });
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addComponent(btnLimpar, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(97)
					.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(49))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLimpar)
						.addComponent(btnSair))
					.addGap(10))
		);
		contentPane.setLayout(gl_contentPane);
		
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

	@Override
	public void salvaLista(List<? extends Object> lista) throws RemoteException {
		for (Object obj : lista) {
			textArea.append(obj.toString() + 
					"\n---------------------------------\n"); 
		}
	}
}
