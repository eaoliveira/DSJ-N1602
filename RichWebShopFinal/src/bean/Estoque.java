package bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

import dao.CarrinhoDao;
import dao.ListaDeProdutos;
import dao.ShopException;
import modelo.Item;
import modelo.Produto;

@ManagedBean
public class Estoque {
	@EJB
	private ListaDeProdutos dao;
	@EJB
	private CarrinhoDao carrinhoDao;
	
	public ListDataModel<ProdutoModel> getLista() {
		List<ProdutoModel> lista = new ArrayList<>();
		
		for (Produto prod : dao.getLista()) {
			lista.add(new ProdutoModel(prod, this));
		}
		
		return new ListDataModel<ProdutoModel>(lista);
	}

	public void poeNoCarrinho(String codigo) {
		try {
			Item itemDoCarrinho = dao.reservaProduto(codigo);
			carrinhoDao.adicionaItem(Utilitarios.getSessionId(), itemDoCarrinho);
			int qtd = carrinhoDao.getQtdItens(Utilitarios.getSessionId());
			Utilitarios.sendMessage("form:msg",  qtd + " itens adicionados no carrinho");
		} catch (ShopException ex) {
			Utilitarios.sendError("form:msg",  ex.getMessage());
		}
	}
}
