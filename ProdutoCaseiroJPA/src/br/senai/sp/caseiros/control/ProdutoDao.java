package br.senai.sp.caseiros.control;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.senai.sp.caseiros.modelo.Produto;

@Stateless
public class ProdutoDao {
	@PersistenceContext(name="ProdutoCaseiroJPA")
	private EntityManager lista; 
	
	public void salvar(Produto obj) {
		lista.merge(obj);
	}
	
	public List<Produto> getLista() {
		return lista.createQuery("from Produto", Produto.class).getResultList();
	}
	
	public void remover(Produto obj) {
		Produto prod = lista.find(Produto.class, obj.getId());
		lista.remove(prod);
	}
	
	public void remover(String[] ids) {
		for (String txt : ids) {
			int id = Integer.parseInt(txt);
			remover(id);
		}
	}
	
	public void remover(Integer id) {
		remover(new Produto(id));
	}
	
	public Produto localiza(Integer id) {
		return lista.find(Produto.class, id);
	}
	
	public List<Produto> localiza(String nome) {
		return lista.createQuery("from Produto like nome=?", Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
}
