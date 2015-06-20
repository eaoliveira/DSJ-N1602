package Rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ShowBindings {
	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.getRegistry("10.84.144.250",1099);
			String[] bindings = reg.list();
			for (String nome : bindings) {
				System.out.println(nome);
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
