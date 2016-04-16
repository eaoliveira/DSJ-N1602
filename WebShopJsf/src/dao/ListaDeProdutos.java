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
	@PersistenceContext(unitName = "WebShopJsf")
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
		Produto item = (Produto) consulta.getSingleResult();
		item.reserva(qtd);
		
		session.persist(item);
		
		return new Item(item);
	}
	
	public void devolveProduto(Item prod) throws ShopException  {
		Query consulta = session.createQuery("from Produto where codigo=:cod");
		consulta.setParameter("cod", prod.getCodigo());
		Produto item = (Produto) consulta.getSingleResult();
		item.setReservado(item.getReservado() - prod.getQuantidade());

		session.persist(item);
	}

	public void vendeProduto(Item prod) throws ShopException  {
		Query consulta = session.createQuery("from Produto where codigo=:cod");
		consulta.setParameter("cod", prod.getCodigo());
		Produto item = (Produto) consulta.getSingleResult();
		item.setReservado(item.getReservado() - prod.getQuantidade());
		item.setQuantidade(item.getQuantidade() - prod.getQuantidade());

		session.persist(item);
	}
}
