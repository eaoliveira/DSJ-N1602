package Anotacao;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * (1) Crie uma anotação chamada "AFazer"
 *     contendo um atributo "descricao" e
 *     outro atributo "data"
 * 
 * (2) Após crie uma classe 
 *     que faça o uso desta anotação criada
 * 
 * (3) No método main desta classe teste
 *     pela existência das anotações
 *     e se positivo, liste estas.
 * 
 */

@Retention(RetentionPolicy.RUNTIME)
@interface AFazer {
	String descricao();

	String data();
}

@AFazer(
		descricao = "Elaborar um exemplo de utilização de  Anotações", 
		data = "17/07/2010")
public class RespostaAnotacao {
	public static void main(String[] args) {
		if (RespostaAnotacao.class.isAnnotationPresent(AFazer.class)) {
			AFazer aFazer = RespostaAnotacao.class.getAnnotation(AFazer.class);
			System.out.println("A Classe " + RespostaAnotacao.class.getName()
					+ "\ntem como objetivo:\n" + aFazer.descricao() + "\nem: "
					+ aFazer.data());
		} else {
			System.out.println("A Classe " + RespostaAnotacao.class.getName()
					+ "\nnão tem a anotação " + AFazer.class.getName());
		}
	}
}
