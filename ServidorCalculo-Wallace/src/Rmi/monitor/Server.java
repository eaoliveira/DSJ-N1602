package Rmi.monitor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Server extends UnicastRemoteObject implements Monitor{
	private static final long serialVersionUID = 1L;

	protected Server() throws RemoteException{
		super();
	}
	public void servidorEmExibicao(String valor) throws RemoteException{
		System.out.println(valor);
	}
	public static void main(String[] args) {
		System.setProperty("java.net.preferIPv4Stack", "true");
		Registry rg = LocateRegistry.createRegistry(1098);
		Server srv = new Server();
		rg.rebind("nome", srv);

	}
	
}
