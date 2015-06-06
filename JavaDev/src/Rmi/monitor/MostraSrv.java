package Rmi.monitor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MostraSrv extends UnicastRemoteObject implements Monitor {
	private static final long serialVersionUID = 1L;

	protected MostraSrv() throws RemoteException {
		super();
	}

	@Override
	public void mostra(String valor) throws RemoteException {
		System.out.println(valor);
	}

	public static void main(String[] args) throws RemoteException {
		System.setProperty("java.net.preferIPv4Stack", "true");
		Registry reg = LocateRegistry.createRegistry(1099);
		MostraSrv srv = new MostraSrv();
		reg.rebind("nome", srv);
	}
}
