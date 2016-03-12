package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.Curso;

@Stateless
public class CursoDao {
	@PersistenceContext(unitName="Curso2")
	private EntityManager manager;
	
	public void adiciona(Curso obj) {
		manager.merge(obj);
	}
		
	public void remove(int id) {
		Curso obj = manager.find(Curso.class, id);
		manager.remove(obj);
	}
		
	public List<Curso> getCursos() {
		return manager.createNamedQuery("todosCursos", Curso.class).getResultList();
	}
}
