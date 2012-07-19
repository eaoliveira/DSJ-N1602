package logica.resposta;

public class Ex08 {
	public static void main(String[] args) {
		try {
			String st = "";
			int it1 = Integer.parseInt(args[0]);
			int it2 = Integer.parseInt(args[1]);
			int it3 = it1 / it2;
			st = "Resultado: " + it3 + "\nOperação concluida com sucesso!";
			System.out.println(st);
//		} catch (Exception ex) {
//			System.out.println("Deu ERRO :(");
	
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Faltam informar os parametros");
		} catch (NumberFormatException ex) {
			System.out.println("Informe numeros!");
		} catch (ArithmeticException ex) {
			System.out.println("Nao informe ZEROS");
		}
	}
}
