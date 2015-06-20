package Rmi.date;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

@SuppressWarnings({ "serial" })
public class ClienteData extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnChamarInterface;
	private JScrollPane scrollPane;
	private JTextArea tfRecebe;
	private JButton btnApagar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
					System.setSecurityManager(new SecurityManager());
					ClienteData frame = new ClienteData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					e.getMessage();
				}
			}
		});
	}

	public ClienteData() {
		setTitle("Implementa\u00E7\u00E3o RMI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btnChamarInterface = new JButton("Chamar Interface");
		btnChamarInterface.addActionListener(this);
		contentPane.add(btnChamarInterface, BorderLayout.NORTH);
		
		btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(this);
		contentPane.add(btnApagar, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tfRecebe = new JTextArea();
		scrollPane.setViewportView(tfRecebe);
		
		this.setLocationRelativeTo(null);
		tfRecebe.setEditable(false);
	}

	public void actionPerformed(ActionEvent e) {
		Object botao = e.getSource();
		
		try {
			
			if (botao.equals(btnChamarInterface)) {
				DataInterface di = (DataInterface)Naming.lookup("rmi://10.84.144.41/iData");
				tfRecebe.append(di.getDate().toString() + "\n");
				
			} else if (botao.equals(btnApagar)) {
				tfRecebe.setText("");
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			ex.getMessage();
		}
		
		
	}
}
