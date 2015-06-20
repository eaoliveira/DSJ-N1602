package Rmi.pacote;

import java.rmi.Naming;
import java.util.Date;

import javax.swing.JOptionPane;

import Rmi.date.DataInterface;

public class DataCliente 
{
	public DataCliente()
	{
		System.setSecurityManager(new SecurityManager());		
		try {
			DataInterface dc = (DataInterface)Naming.lookup("rmi://localhost/data");
			//JOptionPane.showMessageDialog(null, "Data: " + dc.getDate() );
			Date data = new Date();
			data.getDate();
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
			ex.printStackTrace();
		}
	}	
	public static void main(String[] args) 
	{
		new DataCliente();
	}
}

