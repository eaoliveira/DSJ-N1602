package logica.resposta;

public class Ex10 {
	public static void main(String[] args) {
		try {
			int[] arrayDeItens = new int[100];
			for (int i = 0; i <= 100; i++)
				arrayDeItens[i] = i;
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.err.println("Deu Erro!");
		}
		System.out.println("Caféééééééééééééé....");
	}
}
