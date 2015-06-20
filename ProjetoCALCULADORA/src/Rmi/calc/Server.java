package Rmi.calc;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements Calculo {
	private static final long serialVersionUID = 1L;

	protected Server() throws RemoteException {
		super();
	}

	public void servidorEmExibicao(String valor) throws RemoteException {
		System.out.println(valor);
	}

	@Override
	public int soma(int i, int j) throws RemoteException {
		return i + j;
	}

	@Override
	public int multiplica(int i, int j) throws RemoteException {
		return i * j;
	}

	@Override
	public float divide(int i, int j) throws RemoteException {
		return i / j;
	}

	@Override
	public int subtrai(int i, int j) throws RemoteException {
		return i - j;
	}

	public static void main(String[] args) throws RemoteException {
		// System.setProperty("java.net.preferIPv4Stack", "true");
		Registry rg = LocateRegistry.createRegistry(1099);
		Server srv = new Server();
		rg.rebind("calculadora", srv);

	}

}
