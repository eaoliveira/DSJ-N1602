package Rmi.randomNum;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ClienteRandomView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblProximo;
	private JTextField txtDataServer;
	private JSeparator separator;
	private JButton btnMostrarData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.setSecurityManager(new SecurityManager());
					ClienteRandomView frame = new ClienteRandomView();
					frame.setLocationRelativeTo(null);
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
	public ClienteRandomView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		
		lblProximo = new JLabel("Próximo");
		lblProximo.setBounds(12, 117, 412, 40);
		lblProximo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblProximo.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtDataServer = new JTextField();
		txtDataServer.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataServer.setBounds(65, 168, 292, 66);
		txtDataServer.setEditable(false);
		txtDataServer.setForeground(Color.BLUE);
		txtDataServer.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtDataServer.setColumns(10);
		
		separator = new JSeparator();
		separator.setBounds(10, 104, 414, 2);
		panel.setLayout(null);
		
		btnMostrarData = new JButton("Chamar o Próximo");
		btnMostrarData.addActionListener(this);
		btnMostrarData.setBounds(72, 11, 289, 69);
		btnMostrarData.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(btnMostrarData);
		panel.add(txtDataServer);
		panel.add(lblProximo);
		panel.add(separator);
		
		
		
	}

	
	public void actionPerformed(ActionEvent e) {
		Object botao = e.getSource();
		
		if(botao.equals(btnMostrarData)){
			try {
			//RandomInt randomServer = (RandomInt) Naming.lookup("rmi://10.84.144.250/random");
			RandomInt randomServer = (RandomInt) Naming.lookup("rmi://10.84.144.22/random");
			txtDataServer.setText(""+randomServer.nextInt());
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
		}
		
		
	}

}
