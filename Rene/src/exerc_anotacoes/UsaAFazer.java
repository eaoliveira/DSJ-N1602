package exerc_anotacoes;

@AFazer(data = "16/05/2015", descricao = "Exerc�cio de Anota��es")
public class UsaAFazer {
	public static void main(String[] args) {

		// AnnotatedElement element = AFazer.class.getClass();

		AFazer aFazer = UsaAFazer.class.getAnnotation(AFazer.class);
		if(aFazer != null) {
		System.out.println("Na data de: " + aFazer.data()
				+ " deve ser executado: " + aFazer.descricao());
		} else {
			System.out.println("A anota��o AFazer n�o foi utilizada");
		}
	}
}