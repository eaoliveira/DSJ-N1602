package Anotacao;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Documented
@Retention (RetentionPolicy.RUNTIME)
public @interface Afazer {
	
	 String descricao();
	 String data();
}

