package bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;

import modelo.Item;
import modelo.Produto;
import dao.CarrinhoDao;
import dao.ListaDeProdutos;
import dao.ShopException;

@ManagedBean(name = "produto")
@SessionScoped
public class ProdutoBean implements Cloneable {
	private String image;
	private String nome;
	private Double valor;
	private ListDataModel<ProdutoModel> estoque;

	@EJB
	private ListaDeProdutos dao;
	@EJB
	private CarrinhoDao carrinho;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public void alteraQuantidade(ActionEvent ev) {
		Item obj = (Item) ev.getComponent().getAttributes().get("objeto");

		FacesContext ctx = FacesContext.getCurrentInstance();
		try {
			if (obj.getQuantidade() >= 0) {
				Item item = carrinho.localizaItem(getSessionId(), obj.getCodigo());

				int total = obj.getQuantidade() - item.getQuantidade();
				System.out.println("Total:" + total);
				item = dao.reservaProduto(obj.getCodigo(), total);
				item.setQuantidade(total);

				if (item.getQuantidade() != 0) {
					carrinho.adicionaItem(getSessionId(), item);
					ctx.addMessage("wrapper:banner:msg", new FacesMessage(
							"1 item modificado"));
				}
			}
		} catch (ShopException ex) {
			ctx.addMessage("wrapper:banner:msg", new FacesMessage(ex.getMessage()));
		}
	}

	public ListDataModel<ProdutoModel> getEstoque() {
		List<ProdutoModel> lista = new ArrayList<ProdutoModel>();
		for (Produto prod : dao.getLista()) {
			lista.add(new ProdutoModel(prod, this));
		}
		estoque = new ListDataModel<ProdutoModel>(lista);
		return estoque;
	}

	public void setEstoque(ListDataModel<ProdutoModel> estoque) {
		this.estoque = estoque;
	}

	private String getSessionId() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) ctx.getExternalContext()
				.getSession(false);
		String sessionId = session.getId(); // id da sessao
		return sessionId;
	}

	public void poeCarrinho(String cod) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		try {
			carrinho.adicionaItem(getSessionId(), dao.reservaProduto(cod));
			int qtd = carrinho.getQtdItens();
			ctx.addMessage("wrapper:banner:msg", new FacesMessage(qtd
					+ (qtd > 1 ? " itens adicionados" : " item adicionado")
					+ " no carrinho"));
		} catch (ShopException ex) {
			ctx.addMessage("wrapper:banner:msg", new FacesMessage(ex.getMessage()));
		}
	}
}
