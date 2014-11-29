package sp.senai.org.br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sp.senai.org.br.model.Turma;

public class CadastraTurma {
	@PersistenceContext(name="CadTurmaDao")
	private EntityManager srv;
	
	public void salvar (Turma obj){
		srv.merge(obj);
	}
	
	public void remover (Integer id){
		Turma obj = srv.find(Turma.class, id);
	    srv.remove(obj);
	}
	
	public List<Turma> obtemLista() {
		return srv.createNamedQuery("servico.todos", Turma.class).getResultList();
	}
}
