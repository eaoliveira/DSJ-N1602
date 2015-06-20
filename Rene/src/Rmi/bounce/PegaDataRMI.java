package Rmi.bounce;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import java.text.SimpleDateFormat;

import Rmi.date.DataInterface;

public class PegaDataRMI extends RemoteObject{

	public static void main(String[] args) throws RemoteException{
		System.setSecurityManager(new SecurityManager());
		
		try {
			DataInterface dataRemote = (DataInterface) Naming.lookup("rmi://10.84.144.250/data");
			SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.println(sdfr.format( dataRemote.getDate()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
