package Rmi.MeusSrvs.MeuSrvRandom;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MinhaInterfaceRandom extends Remote{
	public int meuRandom() throws RemoteException;
}
