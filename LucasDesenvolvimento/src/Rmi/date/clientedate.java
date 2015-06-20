package Rmi.date;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.text.DateFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class clientedate extends JFrame implements ActionListener, Runnable {

	private JPanel contentPane;
	private JButton btndata;
	private JButton btnSair;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField txtdate;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.setSecurityManager(new SecurityManager());
					clientedate frame = new clientedate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public clientedate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btndata = new JButton("Data");
		btndata.setBounds(10, 227, 89, 23);
		btndata.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(335, 227, 89, 23);
		btnSair.addActionListener(this);
		
		panel = new JPanel();
		panel.setBounds(15, 119, 409, 79);
		
		lblNewLabel = new JLabel("Data do Servidor");
		lblNewLabel.setBounds(109, 34, 200, 50);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		contentPane.setLayout(null);
		contentPane.add(panel);
		
		txtdate = new JTextField();
		txtdate.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtdate, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addComponent(txtdate, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.add(btndata);
		contentPane.add(btnSair);
		contentPane.add(lblNewLabel);
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		
		if(botao.equals(btndata)){
			Thread data = new Thread(this);
			data.start();
		}else{
			System.exit(0);
		}
		
	}


	@Override
	public void run() {

		try{
				DataInterface obj = (DataInterface) Naming.lookup("rmi://10.84.144.24/data");
				DateFormat df = DateFormat.getDateInstance();
		     	txtdate.setText(df.format(obj.getDate()));
			}catch(Exception ex){
			}
	}
	
	
}
