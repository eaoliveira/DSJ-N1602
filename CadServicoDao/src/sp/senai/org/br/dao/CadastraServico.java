package sp.senai.org.br.dao;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sp.senai.org.br.model.Servico;

@Stateless
public class CadastraServico {
	@PersistenceContext(name="CadServicoDao")
	private EntityManager srv;
	
	public void salvar(Servico obj) {
		srv.merge(obj);
	}
	
	public void remover(Integer id) {
		Servico obj = srv.find(Servico.class, id);
		srv.remove(obj);
	}
	
	public List<Servico> obtemLista() {
		return srv.createNamedQuery("servico.todos", Servico.class).getResultList();
	}
}
