package Anotacao.resposta;

import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Retention;

@Retention(RetentionPolicy.RUNTIME)
public @interface AFazer {
	String data();

	String descricao();
}
