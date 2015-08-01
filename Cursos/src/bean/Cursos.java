package bean;

import java.util.List;

import modelo.Curso;

public class Cursos {
	private List<Curso> itens;
	
	public Cursos(List<Curso> obj) {
		itens = obj;
	}
	
	public List<Curso> getItens() {
		return itens;
	}
	
	public int getCount() {
		return itens.size();
	}
}
