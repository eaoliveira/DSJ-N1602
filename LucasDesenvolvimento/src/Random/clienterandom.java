package Random;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Rmi.randomNum.RandomInt;

@SuppressWarnings("serial")
public class clienterandom extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNumeros;
	private JButton btnSair;
	private JPanel panel;
	private JTextField txtnum;
	private JLabel lblNumeros;

	
	public static void main(String[] args) {
		
	
				System.setSecurityManager(new SecurityManager());
				try {
					
					clienterandom frame = new clienterandom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		


	
	public clienterandom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnNumeros = new JButton("Numeros");
		btnNumeros.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		
		panel = new JPanel();
		
		lblNumeros = new JLabel("Numeros !");
		lblNumeros.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeros.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 21));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNumeros)
									.addPreferredGap(ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
									.addComponent(btnSair))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(150)
							.addComponent(lblNumeros, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNumeros)
					.addGap(51)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNumeros)
						.addComponent(btnSair))
					.addContainerGap())
		);
		
		txtnum = new JTextField();
		txtnum.setHorizontalAlignment(SwingConstants.CENTER);
		txtnum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtnum.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(98)
					.addComponent(txtnum, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(txtnum, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	public void actionPerformed(ActionEvent ev) {
			Object botao = ev.getSource();
		
				if(botao.equals(btnNumeros)){
					try{
						RandomInt obj = (RandomInt) Naming.lookup("rmi://10.84.144.24/random");
						txtnum.setText(String.valueOf(obj.nextInt()));
						}catch(Exception ex){
							ex.printStackTrace();
						}
				}else
						System.exit(0);
				}
		
	
	}

