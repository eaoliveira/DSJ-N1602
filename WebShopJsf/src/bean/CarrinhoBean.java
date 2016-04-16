package bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;

import modelo.Item;
import dao.CarrinhoDao;
import dao.ShopException;

@ManagedBean(name = "carrinho")
@SessionScoped
public class CarrinhoBean {
	@EJB
	private CarrinhoDao dao;
	private ListDataModel<Item> lista;

	public ListDataModel<Item> getLista() {
		lista = new ListDataModel<Item>(dao.getLista(getSessionId()));
		return lista;
	}

	public void setLista(ListDataModel<Item> lista) {
		this.lista = lista;
	}

	public void removeItem(ActionEvent ev) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		try {
			String codigo = (String) ev.getComponent().getAttributes()
					.get("codigo");
			dao.removeItem(getSessionId(), codigo);
		} catch (ShopException ex) {
			ctx.addMessage("form:msg", new FacesMessage(ex.getMessage()));
		}
	}

	public double getTotal() {
		return dao.getTotal(getSessionId());
	}

	private String getSessionId() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) ctx.getExternalContext()
				.getSession(false);
		String sessionId = session.getId(); // id da sessao
		return sessionId;
	}
}
