package Rmi.randomNum;

import java.rmi.Naming;

public class RandomCliente {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());
		try {
			RandomInt ri = (RandomInt) Naming.lookup("rmi://10.190.39.250/random");
			for (int i = 0; i < 10; i++)
				System.out.println((i+1) +":" + ri.nextInt());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
