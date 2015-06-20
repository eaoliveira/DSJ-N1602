package Rmi;

import java.rmi.Naming;

import javax.swing.JOptionPane;

import Rmi.calc.Calculo;

public class calc_RMI {
	
	public static void main(String args[]) {
		System.setSecurityManager(new SecurityManager());
		
		try{
		
		Calculo obj = (Calculo)Naming.lookup("rmi://10.84.144.250/calculadora");
		JOptionPane.showMessageDialog(null, String.valueOf(obj.soma(10,35)));
		JOptionPane.showMessageDialog(null, String.valueOf(obj.multiplica(10,35)));
		JOptionPane.showMessageDialog(null, String.valueOf(obj.divide(10,35)));
		JOptionPane.showMessageDialog(null, String.valueOf(obj.subtrai(10,35)));
		}
		catch (Exception ex){
			System.out.println(ex);
		}
	}
	
	
}