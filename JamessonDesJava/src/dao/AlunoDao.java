package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import bean.AlunoBean;


@Stateless
public class AlunoDao {

	@PersistenceContext(unitName="javades")
	private EntityManager sessao;

	//Adicionando ou atualizando o objeto Alunos
	public void adiciona(AlunoBean obj) {
		sessao.merge(obj);
	}

	//Remover a classe Alunos passando o id do aluno
	public void remove(int id) {
		AlunoBean praRemover = sessao.find(AlunoBean.class, id);
		sessao.remove(praRemover);
		
	}

	// select
	public AlunoBean getAlunos() {		
		return new AlunoBean(sessao.createQuery("from Alunos as e",AlunoBean.class).getResultList());
		
	}
}
