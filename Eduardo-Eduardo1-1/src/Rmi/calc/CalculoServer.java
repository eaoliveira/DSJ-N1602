package Rmi.calc;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import javax.naming.Context;
import javax.naming.InitialContext;

public class CalculoServer extends UnicastRemoteObject implements Calculo {
	private static final long serialVersionUID = 1L;

	public CalculoServer() throws RemoteException {
		super();
	}

	@Override
	public float divide(int i, int j) throws RemoteException {
		return i / (float) j;
	}

	@Override
	public int multiplica(int i, int j) throws RemoteException {
		return i * j;
	}

	@Override
	public int soma(int i, int j) throws RemoteException {
		return i + j;
	}

	@Override
	public int subtrai(int i, int j) throws RemoteException {
		return i - j;
	}

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			CalculoServer d = new CalculoServer();
			Context ctx = new InitialContext();
			ctx.bind("calculadora", d);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
