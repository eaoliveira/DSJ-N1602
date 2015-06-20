package anotacoes;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface AFazer {
	String descricao();
	String data();
}
