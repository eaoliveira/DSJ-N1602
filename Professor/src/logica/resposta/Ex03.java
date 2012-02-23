package logica.resposta;

public class Ex03 {
	public static void main(String[] args) {
		int total = 1;
		int i = 1;
		while ( i <= 15) {
			  total *= i;
			  System.out.format("%d X ", i);
			  i+=2;
		}
		System.out.format("\nTotal: %d\n", total);
	}
}
