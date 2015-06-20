package Anotacao;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AFazer {
	
	String decricao() default "Detalhes";
	String data() default "99/99/9999";
}
