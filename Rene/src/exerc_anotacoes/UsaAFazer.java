package exerc_anotacoes;

@AFazer(data = "16/05/2015", descricao = "Exercício de Anotações")
public class UsaAFazer {
	public static void main(String[] args) {

		// AnnotatedElement element = AFazer.class.getClass();

		AFazer aFazer = UsaAFazer.class.getAnnotation(AFazer.class);
		if(aFazer != null) {
		System.out.println("Na data de: " + aFazer.data()
				+ " deve ser executado: " + aFazer.descricao());
		} else {
			System.out.println("A anotação AFazer não foi utilizada");
		}
	}
}