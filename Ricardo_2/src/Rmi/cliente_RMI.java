package Rmi;

import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Rmi.date.DataInterface;

public class cliente_RMI {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	
		//public cliente_RMI(){
		//	setLocation(200,200);
		//	setSize(300,150);
		//	setResizable(false);			
		//	add(panel);
		//	panel.add(button);
		//}

public static void main(String args[]) {
	System.setSecurityManager(new SecurityManager());
	//JFrame cliente_RMI = new cliente_RMI();
	//cliente_RMI.setVisible(true);
	
	try{
	
	DataInterface obj = (DataInterface)Naming.lookup("rmi://10.84.144.250/data");
	JOptionPane.showMessageDialog(null, String.valueOf(obj.getDate()));
	}
	catch (Exception ex){
		System.out.println(ex);
	}
}
	
	
}
