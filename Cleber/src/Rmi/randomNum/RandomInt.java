package Rmi.randomNum;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RandomInt extends Remote {
	public int nextInt() throws RemoteException;
}
