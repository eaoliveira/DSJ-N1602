package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import modelo.Curso;

public class CursoDao {
	private List<Curso> lista = new ArrayList<Curso>();
	private static CursoDao referencia = null;
	private int id = 0;

	private CursoDao() {
		
		
		// Código de Exemplo de funcionalidade do Java 8
		
//		adiciona(obj -> 
//				 obj.setNome("Curso de Programação Andriod")
//				.setDescr("Desenvolvimento de aplicações Andriod")
//		);
//		
//		
//		adiciona(obj -> obj.setNome("Curso de Desenvolvimento Java")
//				.setDescr("Desenvolvimento de aplicações WEB com Java (Servlet/JSP/JSF/EJB e JPA")
//		);

//		adiciona(new Consumer<Curso>() {
//			@Override
//			public void accept(Curso obj) {
//				obj.setNome("Curso de Programação Andriod")
//				.setDescr("Desenvolvimento de aplicações Andriod");
//			}
//		});
//
//		adiciona(new Curso()
//				.setNome("Curso de Desenvolvimento Java")
//				.setDescr("Desenvolvimento de aplicações WEB com Java (Servlet/JSP/JSF/EJB e JPA")
//		);
	}

	public static CursoDao getInstance() {
		if (referencia == null)
			referencia = new CursoDao();

		return referencia;
	}

	public void adiciona(Curso obj) {
		obj.setId(id++);
		lista.add(obj);
	}
	
	public static void adiciona(Consumer<Curso> bloco) {
		Curso obj = new Curso();
		bloco.accept(obj);
		getInstance().adiciona(obj);
	}
		
	public void remove(int id) {
		for (int i = 0; i < lista.size(); i++) {
			Curso c = lista.get(i);
			if (c.getId() == id) {
				lista.remove(i);
				break;
			}
		}
	}
		
	public List<Curso> getCursos() {
		return Collections.synchronizedList(new ArrayList<>(lista));
	}
}
