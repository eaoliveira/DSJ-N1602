package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bean.Cursos;
import modelo.Curso;

public class CursoDao {
	private List<Curso> lista = new ArrayList<Curso>();
	private static CursoDao referencia = null;
	private int id = 0;

	private CursoDao() {
		Curso c =  new Curso();
		c.setNome("Curso de Programação Andriod");
		c.setDescr("Desenvolvimento de aplicações Andriod");
		adiciona(c);
		c =  new Curso();
		c.setNome("Curso de Desenvolvimento Java");
		c.setDescr("Desenvolvimento de aplicações WEB com Java (Servlet/JSP/JSF/EJB e JPA");
		adiciona(c);
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
		
	public void remove(int id) {
		for (int i = 0; i < lista.size(); i++) {
			Curso c = lista.get(i);
			if (c.getId() == id) {
				lista.remove(i);
				break;
			}
		}
	}
		
	public Cursos getCursos() {
		return new Cursos(Collections.synchronizedList(lista));
	}
}
