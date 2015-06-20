package Rmi.MeusSrvs.MeuSrvCalculadora;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClienteMeuSrvCalculadora {
	public static void main(String[] args) {
		try {
			MinhaInterfaceCalculadora calc = (MinhaInterfaceCalculadora) Naming.lookup("rmi://localhost/meuSrvCalculadora");
			System.out.println(calc.divide(10, 5));
			System.out.println(calc.soma(10, 5));
			System.out.println(calc.multiplica(10, 5));
			System.out.println(calc.subtrai(10, 5));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
