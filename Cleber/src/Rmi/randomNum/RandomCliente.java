package Rmi.randomNum;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;

import Rmi.randomNum.*;

public class RandomCliente {

	public static void main(String[] args) throws Exception{
		
		System.setSecurityManager(new SecurityManager());
		RandomInt random = (RandomInt)Naming.lookup("rmi://10.84.144.250/random");
		System.out.println(random.nextInt());

	}

}
