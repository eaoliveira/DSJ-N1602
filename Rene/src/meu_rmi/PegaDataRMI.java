package meu_rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;

public class PegaDataRMI extends RemoteObject{

	public static void main(String[] args) throws RemoteException{
		System.setSecurityManager(new SecurityManager());
		
		try {
			DataInterface dataRemote = (DataInterface) Naming.lookup("rmi://10.84.144.250/data");
			System.out.println(dataRemote);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
