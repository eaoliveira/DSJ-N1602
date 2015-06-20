package anotacoes.ex01;

import java.lang.reflect.AnnotatedElement;

public class TestarAnotacao {

	public static void main(String[] args) throws NoSuchMethodException,
			SecurityException {

		//verifica se esta classe contem uma anotação no método(com sua respectiva assinatura)
		AnnotatedElement element = ProgramaComAnotacao.class.getMethod("cadastrarCliente", Integer.class, String.class);

		// Obtém uma referência é anotação
		AFazer anotacao = element.getAnnotation(AFazer.class);

		// Acessa o valor associado ao atributo imprime na tela
		System.out.printf(anotacao.descricao());

	}

}
