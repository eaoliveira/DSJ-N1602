package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import bean.TurmaBean;
import modelo.Turma;

@Stateless
public class TurmaDao {
	@PersistenceContext(unitName="javades")
	private EntityManager sessao;

	//Adicionando ou atualizando o objeto Turma
	public void adiciona(Turma obj) {
		sessao.merge(obj);
	}

	//Remover a classe Turma passando o id da turma
	public void remove(int id) {
		Turma praRemover = sessao.find(Turma.class, id);
		sessao.remove(praRemover);
	}

	// select - 
	public TurmaBean getTurmas() {		
		return new TurmaBean(sessao.createQuery("from Empresa as e",Turma.class).getResultList());
	}
}
