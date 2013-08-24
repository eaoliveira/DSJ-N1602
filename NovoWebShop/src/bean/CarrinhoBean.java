package bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;

import modelo.Item;
import dao.CarrinhoDao;

@ManagedBean(name="carrinho")
@SessionScoped
public class CarrinhoBean {
	@EJB
	private CarrinhoDao dao;
	private ListDataModel<Item> lista;
		
	public ListDataModel<Item> getLista() {
		lista = new ListDataModel<Item>(dao.getLista());
		return lista;
	}

	public void setLista(ListDataModel<Item> lista) {
		this.lista = lista;
	}

	public void removeItem(ActionEvent ev) {
		String codigo = (String) ev.getComponent().getAttributes().get("codigo");
		dao.removeItem(codigo);
	}
	
	public double getTotal() {
		return dao.getTotal();
	}
}
