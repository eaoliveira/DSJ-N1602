package Rmi.Exercicio2;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Rmi.randomNum.RandomInt;

@SuppressWarnings("serial")
public class ClientRadomInt extends JFrame {
	public ClientRadomInt() {
		System.setSecurityManager(new SecurityManager());

		JTextField tfData = new JTextField(50);
		JButton btStart = new JButton("Próximo Inteiro");
		btStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					//RandomInt bi = (RandomInt)Naming.lookup("rmi://10.84.144.250/random");
					RandomInt bi = (RandomInt) Naming.lookup("rmi://127.0.0.1/numero");
					  tfData.setText(String.valueOf(bi.nextInt()));

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					ex.printStackTrace();
				}
			}
		});
		setLayout(new BorderLayout());
		add(btStart, BorderLayout.CENTER);
		add(tfData,BorderLayout.NORTH);
		setSize(300, 100);
		setTitle("Bounce Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ClientRadomInt();
	}
}
