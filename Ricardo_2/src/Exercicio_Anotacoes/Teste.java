package Exercicio_Anotacoes;

// ESTRUTURA PADRAO PARA COLETA DAS ANOTACOES

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Teste {
	
	String descricao() default "Detalhes:"; // Atributos da Anotacao
	String data() default "99/99/9999";		// Atributos da Anotacao
	

}
