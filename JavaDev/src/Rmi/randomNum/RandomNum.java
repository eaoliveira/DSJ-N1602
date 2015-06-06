package Rmi.randomNum;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import javax.naming.Context;
import javax.naming.InitialContext;

@SuppressWarnings("serial")
public class RandomNum extends UnicastRemoteObject implements RandomInt {
	public RandomNum() throws RemoteException {
		super();
	}

	@Override
	public int nextInt() throws RemoteException {
		return (int) (Math.random() * 10101010);
	}

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			RandomNum d = new RandomNum();
			Context ctx = new InitialContext();
			ctx.bind("random", d);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
