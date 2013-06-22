package Rmi.registrosRmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Random;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Rmi.calc.Calculo;
import Rmi.date.DataInterface;
import Rmi.randomNum.RandomInt;

@SuppressWarnings("serial")
public class SuperClass extends UnicastRemoteObject 
	implements DataInterface, Calculo, RandomInt {

	protected SuperClass() throws RemoteException {
	}

	@Override
	public int nextInt() throws RemoteException {
		return new Random().nextInt();
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
	public float divide(int i, int j) throws RemoteException {
		return i / j;
	}

	@Override
	public int subtrai(int i, int j) throws RemoteException {
		return i - j;
	}

	@Override
	public Date getDate() throws RemoteException {
		return new Date();
	}

	public static void main(String[] args) throws RemoteException, NamingException  {
		SuperClass obj = new SuperClass();
		System.setProperty("java.net.preferIPv4Stack", "true");
		LocateRegistry.createRegistry(1099);
		Context ctx = new InitialContext();
		ctx.bind("data", obj);
		ctx.bind("calculadora", obj);
		ctx.bind("random", obj);
	}
}
