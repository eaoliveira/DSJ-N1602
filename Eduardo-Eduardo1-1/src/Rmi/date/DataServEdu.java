package Rmi.date;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.Date;

public class DataServEdu extends UnicastRemoteObject implements DataInterface {
	private static final long serialVersionUID = 1L;
	
	protected DataServEdu() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Date getDate() throws RemoteException {
		 
		Calendar outradata = Calendar.getInstance();
		outradata.set(Calendar.DAY_OF_MONTH, 10);
		outradata.set(Calendar.MONTH, Calendar.OCTOBER);
		outradata.set(Calendar.YEAR, 1995);
		return new Date(outradata.getTimeInMillis());
		
	}
	
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		System.setProperty("java.net.preferIPv4stack", "true");
		Registry reg = LocateRegistry.createRegistry(1099);
		DataServEdu serv = new DataServEdu();
		reg.bind("data", serv);
	}

}
