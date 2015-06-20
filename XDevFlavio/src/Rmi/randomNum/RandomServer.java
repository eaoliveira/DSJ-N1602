package Rmi.randomNum;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class RandomServer extends UnicastRemoteObject implements RandomInt {
	private static final long serialVersionUID = 1L;

	protected RandomServer() throws RemoteException {
		super();
	}

	@Override
	public int nextInt() throws RemoteException {
		Random rnd = new Random();
		int valor = rnd.nextInt(100);
		return valor;
	}
	
	public static void main(String[] args) throws RemoteException{
		System.setProperty("java.net.preferIPv4Stack", "true");
		Registry reg = LocateRegistry.createRegistry(1099);
		RandomServer rsv = new RandomServer();
		reg.rebind("iRandom", rsv);
	}

}
