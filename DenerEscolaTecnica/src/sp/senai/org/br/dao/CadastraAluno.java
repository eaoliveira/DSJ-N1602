package sp.senai.org.br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sp.senai.org.br.model.Aluno;

public class CadastraAluno {
	
	@PersistenceContext(name="CadAlunoDao")
	private EntityManager srv;
	
	public void salvar (Aluno obj){
		srv.merge(obj);
	}

	public void remover (Integer matricula){
		Aluno obj = srv.find(Aluno.class, matricula);
	    srv.remove(obj);
	}
	
	public List<Aluno> obtemLista() {
		return srv.createNamedQuery("aluno.todos", Aluno.class).getResultList();
	}
	
}
