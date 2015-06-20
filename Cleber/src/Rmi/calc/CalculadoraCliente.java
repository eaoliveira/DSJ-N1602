package Rmi.calc;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class CalculadoraCliente {

	public static void main(String[] args) throws Exception {
		System.setSecurityManager(new SecurityManager());
		Calculo calculo = (Calculo) Naming
				.lookup("rmi://10.84.144.250/calculadora");

		boolean sair = true;
		int opcao = 0;
		Scanner s = new Scanner(System.in);
		while (sair) {
			System.out.println("Escolha a operação:" + "\n" + "1-Soma" + "\n"
					+ "2-Multiplicação" + "\n" + "3-Divisão " + "\n"
					+ "4-Subtração" + "\n" + "5-Sair");
			opcao = s.nextInt();

			if (opcao == 1) {
				System.out.println("Digite o primeiro número:");
				Scanner t = new Scanner(System.in);
				int i = t.nextInt();
				System.out.println("Digite o segundo número:");
				int j = t.nextInt();
				System.out.println("Resultado: " + calculo.soma(i, j));
			}
			if (opcao == 2) {
				System.out.println("Digite o primeiro número:");
				Scanner t = new Scanner(System.in);
				int i = t.nextInt();
				System.out.println("Digite o segundo número:");
				int j = t.nextInt();
				System.out.println("Resultado: " + calculo.multiplica(i, j));
			}
			if (opcao == 3) {
				System.out.println("Digite o primeiro número:");
				Scanner t = new Scanner(System.in);
				int i = t.nextInt();
				System.out.println("Digite o segundo número:");
				int j = t.nextInt();
				System.out.println("Resultado: " + calculo.divide(i, j));
			}
			if (opcao == 4) {
				System.out.println("Digite o primeiro número:");
				Scanner t = new Scanner(System.in);
				int i = t.nextInt();
				System.out.println("Digite o segundo número:");
				int j = t.nextInt();
				System.out.println("Resultado: " + calculo.subtrai(i, j));
			}
			if (opcao == 5) {
				sair = false;
			}
		}
	}

}
