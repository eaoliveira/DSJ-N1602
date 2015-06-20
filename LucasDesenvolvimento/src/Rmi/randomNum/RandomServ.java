package Rmi.randomNum;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class RandomServ extends UnicastRemoteObject implements RandomInt {

	protected RandomServ() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public int nextInt() throws RemoteException {
		Random  random = new Random();
		return random.nextInt(100);
	}

	public static void main(String[] args) throws RemoteException {
		System.setProperty("java.net.preferIPv4Stack", "true");
		Registry reg = LocateRegistry.createRegistry(1099);
		RandomServ srv = new RandomServ();
		reg.rebind("random", srv);
	}
	
	
}
