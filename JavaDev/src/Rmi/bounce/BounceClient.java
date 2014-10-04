package Rmi.bounce;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class BounceClient extends JFrame {
	public BounceClient() {
		System.setSecurityManager(new SecurityManager());

		JButton btStart = new JButton("Criar Bola");
		btStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					BounceInterface bi = (BounceInterface)Naming.lookup("rmi://10.190.39.250/ball");
					
					bi.createBall(new Color((int) Math.ceil(Math.random() * 255), 
											(int) Math.ceil(Math.random() * 255), 
											(int) Math.ceil(Math.random() * 255)));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					ex.printStackTrace();
				}
			}
		});
		add(btStart, "Center");
		setSize(100, 50);
		setTitle("Bounce Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BounceClient();
	}
}
