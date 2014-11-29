package bean;

import java.util.List;

import modelo.Aluno;


public class Alunos {
	
	private List<Aluno> itens;
	
	public Alunos (List<Aluno> obj) {
		itens = obj;
	}
	
	public List<Aluno> getItens () {
		return itens;
	}
	
	public int getCount () {
		return itens.size ();
	}

}
