package Rmi.calc;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculoCliente {
	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.getRegistry("10.190.39.250");
			Calculo calc = (Calculo) reg.lookup("calculadora");
			System.out.println("Soma        : " + calc.soma(12, 13));
			System.out.println("Subtra��o   : " + calc.subtrai(12, 11));
			System.out.println("Mutiplica��o: " + calc.multiplica(19, 13));
			System.out.println("Divis�o     : " + calc.divide(19, 13));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
