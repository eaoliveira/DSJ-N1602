package Rmi.Exercicio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Rmi.bounce.BounceInterface;
import Rmi.date.DataInterface;

@SuppressWarnings("serial")
public class DataClient extends JFrame {
	public DataClient() {
		System.setSecurityManager(new SecurityManager());

		JTextField tfData = new JTextField(50);
		JButton btStart = new JButton("Criar Bola");
		btStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					//DataInterface bi = (DataInterface)Naming.lookup("rmi://10.84.144.250/data");//Servidor do professor
					DataInterface dt = (DataInterface) Naming.lookup("rmi://127.0.0.1/data");
					  tfData.setText(String.valueOf(dt.getDate()));

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					ex.printStackTrace();
				}
			}
		});
		setLayout(new BorderLayout());
		add(btStart, BorderLayout.CENTER);
		add(tfData,BorderLayout.NORTH);
		setSize(200, 100);
		setTitle("Bounce Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new DataClient();
	}
}
