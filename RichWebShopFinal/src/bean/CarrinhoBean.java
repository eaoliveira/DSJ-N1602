package bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

import dao.CarrinhoDao;
import dao.ShopException;
import modelo.Item;

@ManagedBean(name="carrinho")
public class CarrinhoBean {
	@EJB
	private CarrinhoDao dao;
	
	public ListDataModel<ItemModel> getLista() {
		List<ItemModel> lista = new ArrayList<>();
		
		for (Item item : dao.getLista(Utilitarios.getSessionId())) {
			lista.add(new ItemModel(item, this));
		}
		
		return new ListDataModel<ItemModel>(lista);
	}
	
	public double getTotal() {
		return dao.getTotal(Utilitarios.getSessionId());
	}
	
	public void removeItem(String codigo) {
		try {
			dao.removeItem(codigo);
		} catch (ShopException ex) {
			Utilitarios.sendError("form:msg",  ex.getMessage());
		}
	}

	public void alteraQtd(Item item) {
		dao.adicionaItem(Utilitarios.getSessionId(), item);
	}
}
