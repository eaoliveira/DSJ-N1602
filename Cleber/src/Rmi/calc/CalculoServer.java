package Rmi.calc;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;



public class CalculoServer extends UnicastRemoteObject implements Calculo {
	
	private static final long serialVersionUID = 1L;

	@Override
	public int soma(int i, int j) throws RemoteException {
		return  i+j;

	}

	@Override
	public int multiplica(int i, int j) throws RemoteException {
		return  i * j;
	
	}

	@Override
	public float divide(int i, int j) throws RemoteException {
		return i / j;
	}
		 
				
	@Override
	public int subtrai(int i, int j) throws RemoteException {
		return i-j;
		
	}

	protected CalculoServer() throws RemoteException {
		super();
	}

	public static void main(String[] args) throws RemoteException {
		System.setProperty("java.net.preferIPv4Stack", "true");
		Registry reg = LocateRegistry.createRegistry(1099);
		CalculoServer cal = new CalculoServer();
		reg.rebind("calculadora", cal);
		System.out.println("Testando Servidor!");

	}


}
