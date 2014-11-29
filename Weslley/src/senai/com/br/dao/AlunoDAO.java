package senai.com.br.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import senai.com.br.bean.Aluno;

@Stateless
public class AlunoDAO {

	@PersistenceContext(unitName="ProjetoEscola")
	private EntityManager dao;
	
	public void salvar(Aluno aluno){
		dao.merge(aluno);
	}
	
	public void remover(Integer id){
		Aluno aluno = dao.find(Aluno.class, id);
		dao.remove(aluno);
	}
	
	public List<Aluno> listarTodos(){
		return dao.createNamedQuery("aluno.todos", Aluno.class).getResultList();
	}
	
}
