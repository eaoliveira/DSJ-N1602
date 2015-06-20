package Rmi.pacote;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import javax.swing.JOptionPane;

import Rmi.date.DataInterface;

public class Server extends UnicastRemoteObject implements DataInterface {
	private static final long serialVersionUID = 1L;

	protected Server() throws RemoteException {
		super();
	}

	@Override
	public Date getDate() throws RemoteException {
		Date data = new Date();
		//data.getDate();
		JOptionPane.showMessageDialog(null, data);
		return null;
	}

	public static void main(String[] args) throws RemoteException {
		// System.setProperty("java.net.preferIPv4Stack", "true");
		Registry rg = LocateRegistry.createRegistry(1099);
		Server srv = new Server();
		rg.rebind("data", srv);

	}
	
}
