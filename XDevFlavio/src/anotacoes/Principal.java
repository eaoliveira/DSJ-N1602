package anotacoes;

import java.lang.reflect.AnnotatedElement;



public class Principal {
	public static void main(String[] args) throws Exception {
		
		AnnotatedElement element = UsandoAnot.class.getMethod("leitura", String.class, Integer.class);
		AFazer groupTodo = element.getAnnotation(AFazer.class);
		
	    System.out.println(groupTodo.data());
	    System.out.println(groupTodo.descricao());

	}

}
