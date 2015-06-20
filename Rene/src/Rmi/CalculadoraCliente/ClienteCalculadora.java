package Rmi.CalculadoraCliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Rmi.calc.Calculo;

public class ClienteCalculadora {
	public static void main(String[] args) {
		
		System.setSecurityManager(new SecurityManager());
		
		try {
			Calculo calculadora = (Calculo) Naming.lookup("rmi://10.84.144.250/calculadora");
			
			
			System.out.println(calculadora.divide(5, 0) + "");
			System.out.println(calculadora.multiplica(10, 5) + "");
			System.out.println(calculadora.soma(10, 5) + "");
			System.out.println(calculadora.subtrai(10, 5) + "");
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
