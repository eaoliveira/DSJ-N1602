package Rmi.calc;

import java.rmi.Naming;

import javax.swing.JOptionPane;

public class ConexaoCalculadora 
{
	public ConexaoCalculadora()
	{
		System.setSecurityManager(new SecurityManager());		
		try 
		{
			Calculo cc = (Calculo)Naming.lookup("rmi://localhost/calculadora");
			System.out.println("Soma: " + cc.soma(10,2) + "");
			
			System.out.println("Subtração: " + cc.subtrai(10,2));
			
			System.out.println("Multiplicação: " + cc.subtrai(10,2) + "");
			
			System.out.println("Divisão: " + cc.divide(10,2) + "");
			
		} catch (Exception ex) 
		{
			JOptionPane.showMessageDialog(null, ex.getMessage());
			ex.printStackTrace();
		}
	}	
	public static void main(String[] args) 
	{
		new ConexaoCalculadora();
			
	}
}
