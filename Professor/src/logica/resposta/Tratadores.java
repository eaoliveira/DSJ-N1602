package logica.resposta;

public class Tratadores {
	public static void main(String[] args) {
		try {
			String st = "";
			int it1 = Integer.parseInt(args[0]);
			int it2 = Integer.parseInt(args[1]);
			int it3 = it1 / it2;
			st = "Resultado: " + it3 + "\nOperação concluida com sucesso!";
			System.out.println(st);
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Uso:\njava Tratadores arg1 arg2");
		} catch (NumberFormatException ex) {
			System.out.println("Os argumentos devem ser numéricos");
		} catch (ArithmeticException ex) {
			System.out.println("O 2º argumento deve ser diferente de zero");
		}
	}
}
