package Rmi.calc;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraServEdu extends UnicastRemoteObject implements Calculo {
	private static final long serialVersionUID = 1L;
	
	protected CalculadoraServEdu() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public int soma(int i, int j) throws RemoteException {
		// TODO Auto-generated method stub
		return (i+j);
	}

	@Override
	public int multiplica(int i, int j) throws RemoteException {
		// TODO Auto-generated method stub
		return (i*j);
	}

	@Override
	public float divide(int i, int j) throws RemoteException {
		// TODO Auto-generated method stub
		return (i/j);
	}

	@Override
	public int subtrai(int i, int j) throws RemoteException {
		// TODO Auto-generated method stub
		return (i-j);
	}
	
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		System.setProperty("java.net.preferIPv4stack", "true");
		Registry reg = LocateRegistry.createRegistry(1099);
		CalculadoraServEdu serv = new CalculadoraServEdu();
		reg.bind("calcular", serv);
	}

}
