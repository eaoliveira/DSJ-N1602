package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.Aluno;

@Stateless
public class GerenteDeDados {
	@PersistenceContext(unitName = "CadAluno")
	private EntityManager srv;

	public void salvar(Aluno obj) {
		srv.merge(obj);
	}
	
	public void remover(Integer id) {
		Aluno obj = srv.find(Aluno.class, id);
		srv.remove(obj);
	}
	
	public List<Aluno> obtemLista() {
		return srv.createNamedQuery("aluno.todos", Aluno.class).getResultList();
	}
}



