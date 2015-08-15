package bean;

import modelo.Produto;

public class ProdutoModel {
	private Produto prod;
	private Estoque bean;
	
	public ProdutoModel(Produto obj, Estoque bean) {
		this.prod = obj;
		this.bean = bean;
	}

	public String getDescricao() {
		return prod.getDescricao();
	}

	public String getImagem() {
		return prod.getImagem();
	}

	public Float getValor() {
		return prod.getValor();
	}

	public void poeNoCarrinho() {
		bean.poeNoCarrinho(prod.getCodigo());
	}
}
