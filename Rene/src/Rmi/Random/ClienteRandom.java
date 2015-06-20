package Rmi.Random;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Rmi.randomNum.RandomInt;

public class ClienteRandom {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());

		try {
			RandomInt intRandom = (RandomInt) Naming
					.lookup("rmi://10.84.144.250/random");

			for(int i = 0; i < 10; i++){
				System.out.println(intRandom.nextInt());
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
