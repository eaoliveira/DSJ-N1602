package Rmi.monitor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Monitor extends Remote {
	public void mostra(String valor) throws RemoteException;
}
