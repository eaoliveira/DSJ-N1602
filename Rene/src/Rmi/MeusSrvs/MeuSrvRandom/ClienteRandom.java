package Rmi.MeusSrvs.MeuSrvRandom;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClienteRandom {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());

		try {
			MinhaInterfaceRandom intRandom = (MinhaInterfaceRandom) Naming
					.lookup("rmi://localhost/meuRandom");

			for(int i = 0; i < 10; i++){
				System.out.println(intRandom.meuRandom());
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
