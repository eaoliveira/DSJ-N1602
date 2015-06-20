package Rmi.MeusSrvs.MeuSrvCalculadora;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;

public class MeuSrvCalculadora extends UnicastRemoteObject implements MinhaInterfaceCalculadora{
	static int porta = 1099;
	protected MeuSrvCalculadora() throws RemoteException {
		super();
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
	public int divide(int i, int j) throws RemoteException {
		return i / j;
	}

	@Override
	public int subtrai(int i, int j) throws RemoteException {
		return i - j;
	}
	public static void main(String[] args) {
		System.setProperty("java.net.preferIPv4Stack", "true");
		try {
			
			Registry reg = LocateRegistry.getRegistry(1099);
			MeuSrvCalculadora srvCalculadora = new MeuSrvCalculadora();
			reg.rebind("meuSrvCalculadora", srvCalculadora);
			System.out.println(porta);
//		} catch (ExportException e){
//			porta++;
//			System.out.println(porta);
//			try {
//				new MeuSrvCalculadora();
//			} catch (RemoteException e1) {
//				e1.printStackTrace();
//			}
		}catch (RemoteException e) {
			e.getStackTrace();
		}
	}
}
