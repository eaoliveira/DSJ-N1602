package Rmi.MeusSrvs.MeuSrvCalculadora;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MinhaInterfaceCalculadora extends Remote{
	public int soma(int i, int j) throws RemoteException;
	public int multiplica(int i,int j) throws RemoteException;
	public int divide(int i,int j) throws RemoteException;
	public int subtrai(int i,int j) throws RemoteException;
}
