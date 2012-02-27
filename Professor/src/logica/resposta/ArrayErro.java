package logica.resposta;

public class ArrayErro {
	public static void main(String[] args) {
		try {
		int[] arrayDeItens = new int[100];
			for (int i = 0; i <= 100; i++) {
				arrayDeItens[i] = i;
				System.out.println(arrayDeItens[i]);
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Estouro no Vetor no indice: " + ex.getMessage());
			//System.out.println("["+ex.toString()+"]");
		}
	}
}
