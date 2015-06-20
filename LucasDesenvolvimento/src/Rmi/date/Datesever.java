package Rmi.date;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;


public class Datesever extends UnicastRemoteObject implements DataInterface {

	
	protected Datesever() throws RemoteException {
		super();
		
	}

	private static final long serialVersionUID = 1L;

	@Override
	public Date getDate() throws RemoteException {
		Date date = new Date();
		return date; 
	}

	public static void main(String[] args) throws RemoteException {
		System.setProperty("java.net.preferIPv4Stack", "true");
		Registry reg = LocateRegistry.createRegistry(1099);
		Datesever srv = new Datesever();
		reg.rebind("data", srv);
	}
	
}
