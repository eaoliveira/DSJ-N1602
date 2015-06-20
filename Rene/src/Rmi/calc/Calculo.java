package Rmi.calc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculo extends Remote {
	public int soma(int i, int j) throws RemoteException;
	public int multiplica(int i, int j) throws RemoteException;
	public float divide(int i, int j) throws RemoteException;
	public int subtrai(int i, int j) throws RemoteException;
}
