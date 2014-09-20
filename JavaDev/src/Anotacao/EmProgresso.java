package Anotacao;

import java.lang.annotation.*;

/**
 * Constroi uma anotacao para indicar que o metodo ou classe ainda está em
 * processo de construcao
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface EmProgresso {
}
