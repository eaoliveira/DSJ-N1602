package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.Contato;
import modelo.Fone;

@Stateless
public class NovoGerente {
	@PersistenceContext(unitName="NovoJsf2Jpa")
	private EntityManager dao;
	
	public void salvar(Object obj) {
		dao.merge(obj);
	}
	
	public void addFone(Integer id, Fone obj) {
		Contato cont = localize(id);
		cont.getFones().add(obj);
		dao.merge(cont);
	}
	
	public int size() {
		return getContatos().size();
	}
	
	public int foneSize(Integer id) {
//		"select count(*) from Fone f, Contato c where f.idContato = c.idContato"
		return dao.find(Contato.class, id).getFones().size();
	}
	
	@SuppressWarnings("unchecked")
	public List<Contato> getContatos() {
		return dao.createQuery("from Contato").getResultList();
	}
	
	public void remove(int id) {
		dao.remove(localize(id));
	}
	
	public void remove(int contato, int id) {
		Contato cont = localize(contato);
		List<Fone> listaFone = cont.getFones();
		int indiceFone = listaFone.indexOf(new Fone(id));
		if (indiceFone > -1) {
			listaFone.remove(indiceFone);
		}
		dao.merge(cont);
	}
	
	public Contato localize(int id) {
		return dao.find(Contato.class, id);
	}
}
