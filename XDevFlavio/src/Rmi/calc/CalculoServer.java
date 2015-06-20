package Rmi.calc;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculoServer extends UnicastRemoteObject implements Calculo {
	private static final long serialVersionUID = 1L;

	protected CalculoServer() throws RemoteException {
		super();
	}
	
	@Override
	public int soma(int i, int j) throws RemoteException {
		int somar = i + j;
		return somar;
	}

	@Override
	public int multiplica(int i, int j) throws RemoteException {
		int multi = i * j;
		return multi;
	}

	@Override
	public float divide(int i, int j) throws RemoteException {
		float div = i / j;
		return div;
	}

	@Override
	public int subtrai(int i, int j) throws RemoteException {
		int menos = i - j;
		return menos;
	}
	
	public static void main(String[] args) throws RemoteException {
		System.setProperty("java.net.preferIPv4Stack", "true");
		Registry reg = LocateRegistry.createRegistry(1099);
		CalculoServer csv = new CalculoServer();
		reg.rebind("iCalculo", csv);
	}

}
