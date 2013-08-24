package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import modelo.Item;
import modelo.Produto;

@Stateless
public class ListaDeProdutos {
	@PersistenceContext(unitName = "JsfWebShop")
	private EntityManager session;

	@SuppressWarnings("unchecked")
	public List<Produto> getLista() {
		return session.createQuery("from Produto").getResultList();
	}

	public Item reservaProduto(String cod) throws ShopException {
		return reservaProduto(cod, 1);		
	}
	
	public Item reservaProduto(String cod, int qtd) throws ShopException {
		Query consulta = session.createQuery("from Produto where codigo=:cod");
		consulta.setParameter("cod", cod);
		Produto estoque = (Produto) consulta.getSingleResult();
		estoque.reserva(qtd);
		
		return new Item(estoque);
	}
	
	public void devolveProduto(Item prod) {
		Query consulta = session.createQuery("from Produto where codigo=:cod");
		consulta.setParameter("cod", prod.getCodigo());
		Produto item = (Produto) consulta.getSingleResult();
		item.setReservado(item.getReservado() - prod.getQuantidade());

		session.persist(item);
	}

	public void vendeProduto(Item prod) {
		Query consulta = session.createQuery("from Produto where codigo=:cod");
		consulta.setParameter("cod", prod.getCodigo());
		Produto item = (Produto) consulta.getSingleResult();
		item.setReservado(item.getReservado() - prod.getQuantidade());
		item.setReservado(item.getQuantidade() - prod.getQuantidade());

		session.persist(item);
	}
}
