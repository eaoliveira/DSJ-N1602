package Rmi.MeusSrvs.MeuSrvData;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface MinhaInterfaceData extends Remote{
	public Date minhaData() throws RemoteException;
}
