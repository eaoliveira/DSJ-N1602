package Rmi.randomNum;

import java.rmi.Naming;

public class RandomCliente {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());
		try {
			//RandomInt ri = (RandomInt) Naming.lookup("rmi://10.84.144.250/random");
			RandomInt ri = (RandomInt) Naming.lookup("rmi://127.0.0.1/numero");
			for (int i = 0; i < 10; i++)
				System.out.println((i+1) +":" + ri.nextInt());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
