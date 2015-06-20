package anotacoes.ex01;

import java.lang.reflect.AnnotatedElement;

public class TestarAnotacao {

	public static void main(String[] args) throws NoSuchMethodException,
			SecurityException {

		//verifica se esta classe contem uma anota��o no m�todo(com sua respectiva assinatura)
		AnnotatedElement element = ProgramaComAnotacao.class.getMethod("cadastrarCliente", Integer.class, String.class);

		// Obt�m uma refer�ncia � anota��o
		AFazer anotacao = element.getAnnotation(AFazer.class);

		// Acessa o valor associado ao atributo imprime na tela
		System.out.printf(anotacao.descricao());

	}

}
