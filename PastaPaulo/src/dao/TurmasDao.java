package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.Turma;

@Stateless
public class TurmasDao {
	@PersistenceContext(unitName = "CadAluno")
	private EntityManager srv;

	public void salvar(Turma obj) {
		srv.merge(obj);
	}
	
	public void remover(Integer id) {
		Turma obj = srv.find(Turma.class, id);
		srv.remove(obj);
	}
	
	public List<Turma> obtemLista() {
		return srv.createNamedQuery("aluno.todos", Turma.class).getResultList();
	}
	
	public Turma geTurma(Integer id){
		return srv.find(Turma.class, id);
	}
}

	


