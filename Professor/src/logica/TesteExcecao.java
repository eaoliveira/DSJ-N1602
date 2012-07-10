package logica;

import fundamentos.resposta.EntradaDados;

public class TesteExcecao {
	public static void main(String[] args) {
		double[] lista = new double[4];

		try {
			for (int i = 0; i <= lista.length; i++) {
				lista[i] = EntradaDados.leDouble("informe a nota");
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Xiiii, Marquinho! Fud&$#@");
		} catch(NumberFormatException ex) {
			System.out.println("Nº invalido");
		}
		for (int i = 0; i < lista.length; i++) {
			double d = lista[i];
			System.out.println(d);
		}

	}
}
