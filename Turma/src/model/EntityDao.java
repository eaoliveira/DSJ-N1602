package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EntityDao {
	@PersistenceContext(unitName="Turma")
	private EntityManager sessao;
	
	public List<Turma> getTurmas() {
		return sessao.createNamedQuery("turma.todas",Turma.class).getResultList();
	}
	
	public List<Aluno> getAlunos() {
		return sessao.createNamedQuery("aluno.todos", Aluno.class).getResultList();
	}
	
	public Object salva(Object a) {
		return sessao.merge(a);
	}

	public Turma getTurma(int idturma) {
		return sessao.find(Turma.class, idturma);
	}
	
	public void apagaData(int id) {
		Turma obj = sessao.find(Turma.class, id);
		sessao.remove(obj);
	}

}
