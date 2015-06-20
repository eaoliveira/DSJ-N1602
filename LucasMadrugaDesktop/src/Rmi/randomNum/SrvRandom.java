package Rmi.randomNum;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;


public class SrvRandom extends UnicastRemoteObject implements RandomInt {

	private Random numAleatorio;
	protected SrvRandom() throws RemoteException {
		super();
		numAleatorio = new Random();
		
	}

	private static final long serialVersionUID = 1L;

	@Override
	public int nextInt() throws RemoteException {
		
		return numAleatorio.nextInt(100*(100));
	}
	
	public static void main(String[] args) throws RemoteException {
		System.setProperty("java.net.preferIPv4Stack", "true");
		Registry reg = LocateRegistry.createRegistry(1099);
		SrvRandom srv = new SrvRandom();
		reg.rebind("random", srv);
	}

}
