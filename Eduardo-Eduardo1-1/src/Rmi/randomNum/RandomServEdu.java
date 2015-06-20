package Rmi.randomNum;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

import javax.swing.JOptionPane;

public class RandomServEdu extends UnicastRemoteObject implements RandomInt {
	private static final long serialVersionUID = 1L;
	
	Random num;
	
	protected RandomServEdu() throws RemoteException {
		super();
		num = new Random();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int nextInt() throws RemoteException {
		// TODO Auto-generated method stub
		return num.nextInt(99);
	}
	
	public static void main(String[] args) {
		System.setProperty("java.net.preferIPv4stack","true");
		Registry reg;
		try {
			reg = LocateRegistry.createRegistry(1099);
		
		RandomServEdu serv = new RandomServEdu();
		reg.bind("numero", serv);
		} catch (RemoteException | AlreadyBoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e);
			System.out.println(e);
		}
	}

}
