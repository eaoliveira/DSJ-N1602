package Rmi.MeusSrvs.MeuSrvData;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClienteMeuSrvData {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());
		try {
			MinhaInterfaceData pegaData = (MinhaInterfaceData) Naming.lookup("rmi://localhost/dataServidor");
			
			System.out.println(pegaData.minhaData());
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
