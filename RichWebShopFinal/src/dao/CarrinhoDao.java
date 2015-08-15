package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import modelo.Carrinho;
import modelo.Compra;
import modelo.Item;
import modelo.ItemDeCompra;

@Stateless
public class CarrinhoDao {
	@PersistenceContext(unitName = "JsfWebShop")
	private EntityManager session;
	@EJB
	private ListaDeProdutos dao;
	
	public void adicionaItem(String sessao, Item prod) {
		Carrinho car;
		try {
			Query consulta = session.createQuery("select c from Carrinho c join fetch c.itens where sessao=:sessao");
			consulta.setParameter("sessao", sessao);
			car = (Carrinho) consulta.getSingleResult();
		} catch (NoResultException ex) {
			car = new Carrinho();
			car.setSessao(sessao);
		}

		// Atualiza a data/hora no carrinho
		car.setData(new Date());
		
		int idx = car.getItens().indexOf(prod);
		if(idx != -1) { // achou o produto no carrinho; altera a quantidade
			Item obj = car.getItens().get(idx);
			obj.setQuantidade(prod.getQuantidade());

			/*
			 * obj = 1 
			 * prod = 2  <===
			 * prod - obj = 1
			 * 
			 * obj = 10 
			 * prod = 2 <===
			 * prod - obj = 8

			 */
			
			
			if (obj.getQuantidade() == 0) {
				car.getItens().remove(idx);
				session.remove(obj);
			} 		
		} else { // não achou o produto no carrinho; inclui
			car.getItens().add(prod);
			prod.setCarrinho(car);
		}
		
		session.persist(car);
	}

	public void removeItem(String codigo) throws ShopException {
		Item obj = localizaItem(codigo);
		Carrinho car = obj.getCarrinho();
		car.getItens().remove(obj);
		// Atualiza a data/hora no carrinho
		car.setData(new Date());
		
		session.remove(obj);
		session.persist(car);
		dao.devolveProduto(obj);
//		atualizaData();
	}

	public Item localizaItem(String codigo) {
		System.out.println("localizaItem("+ codigo+")");
		Item obj = null;
		try {
			Query consulta = session
					.createQuery("from Item where codigo=:codigo");
			consulta.setParameter("codigo", codigo);
			obj = (Item) consulta.getSingleResult();
		} catch (NoResultException ex) {
		}
		return obj;
	}
	
	public List<Item> getLista(String sessao) {
		List<Item> itens = null;
	
		try {
			Query consulta = session.createQuery("select c from Carrinho c join fetch c.itens where sessao=:sessao");
			consulta.setParameter("sessao", sessao);
			Carrinho car = (Carrinho) consulta.getSingleResult();
			itens = car.getItens();
		} catch(NoResultException ex) {
			itens = new ArrayList<>();
		}
		return itens;
	}

	public int getQtdItens(String sessao) {
		Query sql = session.createQuery("select count(c) from Item as c where c.carrinho.sessao=:sessao");
		sql.setParameter("sessao", sessao);

		Number numReg = (Number) sql.getSingleResult();
		return numReg.intValue();
	}

	public double getTotal(String sessao) {
		double valorTotal = 0;

		for (Item p : getLista(sessao)) {
			valorTotal += p.getTotal();
		}

		return valorTotal;
	}

	public void finalizaCompra(String id, Compra obj) throws ShopException {
		System.out.println("Sessao: " + id);
		try {
			Query consulta = session.createQuery("Select c from Carrinho c join fetch c.itens where sessao=:sessao");
			consulta.setParameter("sessao", id);
			Carrinho car = (Carrinho) consulta.getSingleResult();
			System.out.println("Carrinho: " + car);
			
			double valorTotal = 0;
			for (Item it : car.getItens()) {
				valorTotal += it.getTotal();
				dao.vendeProduto(it);
				System.out.println("Vendido o Item cod:" + it.getCodigo());
				ItemDeCompra itemCpr = new ItemDeCompra(it);
				obj.getItens().add(itemCpr);
				session.persist(itemCpr);
			}
			obj.setValor(valorTotal);
			
			session.remove(car);
			System.out.println("Compra: " + obj);
			session.persist(obj);
//			tm.unregister(sessionId);
		} catch (NoResultException ex) {
			ex.printStackTrace(System.out);
		}
	}

}
