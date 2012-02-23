package logica.resposta;

public class ExemploExcecao {
	public static void main(String[] args) {
		int i = 0;
		int[] lista = new int[10];
		try {
			while (i <= 10) {
				lista[i] = i++ * 2;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			//System.out.println("Xiiiii, Marquinho! :(");
		}

		System.out.println("Acabou!");
	}
}
