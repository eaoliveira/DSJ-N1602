package alunoPrj.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import alunoPrj.model.Aluno;

@Stateless
public class AlunoDao {
	@PersistenceContext(unitName="ProjetoAluno0")
	private EntityManager em;
	
	public void addAluno(Aluno obj) {
		em.merge(obj);
	}

	public void addAluno(String nome, String matricula) 
			throws AlunoException {
		if (nome.isEmpty() || matricula.isEmpty()) {
           throw new AlunoException("PAM! Preencha todos os campos");
	    } else {
			Aluno obj = new Aluno();
			obj.setNome(nome);
			obj.setMatricula(matricula);
			em.merge(obj);
		}
	}

	public List<Aluno> listAlunos() {
		return em.createQuery("from Aluno", Aluno.class).getResultList();
	}

	public void delAluno(Integer id) {
		Aluno obj = em.find(Aluno.class, id);
		em.remove(obj);
	}
}