package Rmi.MeusSrvs.MeuSrvRandom;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class MeuSRVRandom  extends UnicastRemoteObject implements MinhaInterfaceRandom{
	Random gerador = new Random();
	
	protected MeuSRVRandom() throws RemoteException {
		super();
	}
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		System.setProperty("java.net.preferIPv4Stack", "true");
		Registry reg = LocateRegistry.getRegistry(1099);
		MeuSRVRandom meuRandomSRV = new MeuSRVRandom();
		reg.bind("meuRandom",meuRandomSRV);
		
	}
	@Override
	public int meuRandom() throws RemoteException {
		return gerador.nextInt(2000);
	}
}
