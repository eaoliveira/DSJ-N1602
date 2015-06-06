package Rmi.monitor;

import java.rmi.Naming;

public class MostraCli {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());

		try {
			Monitor obj = (Monitor) Naming.lookup("rmi://10.84.144.250/nome");
			obj.mostra("texto");

		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
}
