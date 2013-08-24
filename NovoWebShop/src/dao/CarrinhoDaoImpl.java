package dao;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Timer;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import modelo.Carrinho;
import modelo.Compra;
import modelo.Item;

@Stateful
public class CarrinhoDaoImpl implements CarrinhoDao, TimerInterface {
	@PersistenceContext(unitName = "JsfWebShop")
	private EntityManager session;
	@EJB
	private TimerManager tm;
	@EJB
	private ListaDeProdutos dao;
	private String sessionId;
	private Calendar cal;

	public String getSession() {
		return sessionId;
	}
	
	public void avisa(Timer timer, String id) {
		Calendar now = Calendar.getInstance();
		if (cal != null && now.after(cal) && sessionId.equals(id)) {
			try {
				Query consulta = session.createQuery("from Carrinho where sessao=:sessao");
				consulta.setParameter("sessao", sessionId);
				Carrinho obj = (Carrinho) consulta.getSingleResult();
				for (Item it : obj.getItens()) {
					dao.devolveProduto(it);
					System.out.println("Liberando o Item cod:" + it.getCodigo());
				}
				session.remove(obj);
			} catch (NoResultException ex) {
			}
			tm.unregister(id);
		}
	}

	private void atualizaData() {
		cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 2);
	}
	
	public void adicionaItem(String sessao, Item prod) {
		Item obj = localizaItem(prod.getCodigo());

		if (obj != null) {
			obj.setQuantidade(obj.getQuantidade() + prod.getQuantidade());
		} else {
			obj = prod;
		}

		Carrinho car;
		try {
			Query consulta = session.createQuery("from Carrinho where sessao=:sessao");
			consulta.setParameter("sessao", sessao);
			car = (Carrinho) consulta.getSingleResult();
		} catch (NoResultException ex) {
			car = new Carrinho();
			car.setSessao(sessao);
		}

		int idx = car.getItens().indexOf(obj);
		if (idx != -1) {
			if (obj.getQuantidade() == 0) {
				car.getItens().remove(idx);
				session.remove(obj);
			} else {
				car.getItens().set(idx, obj);
			}
		} else {
			car.getItens().add(obj);
		}

		session.persist(car);
		atualizaData();
		
		if (sessionId == null) {
			sessionId = sessao;
			tm.register(sessionId, this);
		}
	}

	public void removeItem(String codigo) {
		Item obj = localizaItem(codigo);
		session.remove(obj);
		dao.devolveProduto(obj);
		atualizaData();
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

	@SuppressWarnings("unchecked")
	public List<Item> getLista() {
		return session.createQuery("from Item").getResultList();
	}

	public int getQtdItens() {
		Query sql = session.createQuery("select count(c) from Item as c");
		Number numReg = (Number) sql.getSingleResult();
		return numReg.intValue();
	}

	public double getTotal() {
		double valorTotal = 0;

		for (Item p : getLista()) {
			valorTotal += p.getTotal();
		}

		return valorTotal;
	}

	public void finalizaCompra(String id, Compra obj) {
		System.out.println("Sessao: " + id);
		try {
			Query consulta = session.createQuery("from Carrinho where sessao=:sessao");
			consulta.setParameter("sessao", id);
			Carrinho car = (Carrinho) consulta.getSingleResult();
			System.out.println("Carrinho: " + car);
			for (Item it : car.getItens()) {
				dao.vendeProduto(it);
				System.out.println("Vendido o Item cod:" + it.getCodigo());
			}
			session.remove(car);
			session.persist(obj);
			tm.unregister(sessionId);
		} catch (NoResultException ex) {
			ex.printStackTrace(System.out);
		}
	}
}
