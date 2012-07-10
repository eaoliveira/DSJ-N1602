package logica.resposta;

public class Ex03 {
	public static void main(String[] args) {
		int total = 1;
		for (int i = 1; i <= 15; i += 2) {
			System.out.print(i + " X ");
			total *= i;			// total = total * i
		}
		System.out.println("\nTotal: " + total);
	}
}
