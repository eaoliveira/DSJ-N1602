package Rmi.MeusSrvs.MeuSrvData;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class MeuSrvData extends UnicastRemoteObject implements MinhaInterfaceData{
	protected MeuSrvData() throws RemoteException {
		super();
	}

	public static void main(String[] args) {
		
		try {
			System.setProperty("java.net.preferIPv4Stack", "true");
			Registry reg = LocateRegistry.createRegistry(1099);
			MeuSrvData meuSrvData = new MeuSrvData();
			reg.rebind("dataServidor", meuSrvData);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Date minhaData() throws RemoteException {
		Date data =  new Date();
		return data;
	}
}
