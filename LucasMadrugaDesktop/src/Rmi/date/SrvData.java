package Rmi.date;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;


public class SrvData extends UnicastRemoteObject implements DataInterface {

	private static final long serialVersionUID = 1L;
	
	
	protected SrvData() throws RemoteException {
		super();
		
	}


	@Override
	public Date getDate() throws RemoteException {
		
		Date date = new Date(); 
		return date;
 	
		
	}
	
	public static void main(String[] args) throws RemoteException {
		System.setProperty("java.net.preferIPv4Stack", "true");
		Registry reg = LocateRegistry.createRegistry(1099);
		SrvData srv = new SrvData();
		reg.rebind("data", srv);
	}

	

}
