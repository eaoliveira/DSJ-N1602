package bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import modelo.Compra;
import modelo.Item;
import modelo.ItemDeCompra;
import modelo.TipoCartao;
import dao.CarrinhoDao;

@ManagedBean
@SessionScoped
public class CompraBean {
	@EJB
	private CarrinhoDao carrinho;
	
	protected String numero;
	protected String codigoSeg;
	protected String titular;
	protected TipoCartao cartao;
	protected Collection<SelectItem> cartoes;
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodigoSeg() {
		return codigoSeg;
	}

	public void setCodigoSeg(String codigoSeg) {
		this.codigoSeg = codigoSeg;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public void setCartoes(Collection<SelectItem> cartoes) {
		this.cartoes = cartoes;
	}

	public TipoCartao getCartao() {
		return cartao;
	}

	public void setCartao(TipoCartao cartao) {
		this.cartao = cartao;
	}

	public Collection<SelectItem> getCartoes() {
		cartoes = new ArrayList<SelectItem>();

		for (TipoCartao obj : TipoCartao.values())
			cartoes.add(new SelectItem(obj, obj.toString()));

		return cartoes;
	}
	
	public void changeCartao(ValueChangeEvent ev) {
		setCartao((TipoCartao)ev.getNewValue());
		System.out.println(cartao.toString());
	}

	private String getSessionId() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) ctx.getExternalContext()
				.getSession(false);
		String sessionId = session.getId(); // id da sessao
		return sessionId;
	}
	
	public String comprar() {
		Compra cpr = new Compra();
		cpr.setCartao(numero);
		cpr.setCod(codigoSeg);
		cpr.setNome(titular);
		cpr.setTipo(cartao.toString());
		cpr.setValor(carrinho.getTotal());
		for (Item it : carrinho.getLista()) {
			cpr.getItens().add(new ItemDeCompra(it));
		}
		carrinho.finalizaCompra(getSessionId(), cpr);
		return "index.jsf";
	}
}
