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
			System.out.println("Escolha a opera��o:" + "\n" + "1-Soma" + "\n"
					+ "2-Multiplica��o" + "\n" + "3-Divis�o " + "\n"
					+ "4-Subtra��o" + "\n" + "5-Sair");
			opcao = s.nextInt();

			if (opcao == 1) {
				System.out.println("Digite o primeiro n�mero:");
				Scanner t = new Scanner(System.in);
				int i = t.nextInt();
				System.out.println("Digite o segundo n�mero:");
				int j = t.nextInt();
				System.out.println("Resultado: " + calculo.soma(i, j));
			}
			if (opcao == 2) {
				System.out.println("Digite o primeiro n�mero:");
				Scanner t = new Scanner(System.in);
				int i = t.nextInt();
				System.out.println("Digite o segundo n�mero:");
				int j = t.nextInt();
				System.out.println("Resultado: " + calculo.multiplica(i, j));
			}
			if (opcao == 3) {
				System.out.println("Digite o primeiro n�mero:");
				Scanner t = new Scanner(System.in);
				int i = t.nextInt();
				System.out.println("Digite o segundo n�mero:");
				int j = t.nextInt();
				System.out.println("Resultado: " + calculo.divide(i, j));
			}
			if (opcao == 4) {
				System.out.println("Digite o primeiro n�mero:");
				Scanner t = new Scanner(System.in);
				int i = t.nextInt();
				System.out.println("Digite o segundo n�mero:");
				int j = t.nextInt();
				System.out.println("Resultado: " + calculo.subtrai(i, j));
			}
			if (opcao == 5) {
				sair = false;
			}
		}
	}

}
