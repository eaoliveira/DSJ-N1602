package Rmi;

import java.rmi.Naming;

import javax.swing.JOptionPane;

import Rmi.date.DataInterface;
import Rmi.randomNum.RandomInt;

public class cliente_RMI_random {

	public static void main(String args[]) {
		System.setSecurityManager(new SecurityManager());
		
		try{
		
		RandomInt obj = (RandomInt)Naming.lookup("rmi://10.84.144.250/random");
		JOptionPane.showMessageDialog(null, String.valueOf(obj.nextInt()));
		}
		catch (Exception ex){
			System.out.println(ex);
		}
	}
	
	
}
