package senai.com.br.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import senai.com.br.bean.Turma;

@Stateless
public class TurmasDAO {
	

	@PersistenceContext(unitName="ProjetoEscola")
	private EntityManager dao;
	
	public void salvar(Turma turma){
		dao.merge(turma);
	}
	
	public void remover(Integer id){
		Turma turma= dao.find(Turma.class, id);
		dao.remove(turma);
	}
	
	public List<Turma> listarTodos(){
		return dao.createNamedQuery("aluno.todos", Turma.class).getResultList();
	}
	
	public Turma getTurma(Integer id){
		return dao.find(Turma.class, id);
	}
	

}
