package Anotacao.resposta;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Categoria {
	String tipo() default "Contrato";
	String data();
}

@Categoria(data = "18-4-1994", tipo = "Teste")
class AClasseAnotada {
}

public class UsoAnotacao {
	public static void main(String[] args) {
		Class<?> cls = AClasseAnotada.class;
		if (cls.isAnnotationPresent(Categoria.class)) {
			Categoria cat = cls.getAnnotation(Categoria.class);
			System.out.println(cat.data() + " - " + cat.tipo());
		} else {
			Annotation[] lista = cls.getAnnotations();
			for (Annotation item : lista) {
				System.out.println(item.getClass().getName());
			}
		}
	}
}