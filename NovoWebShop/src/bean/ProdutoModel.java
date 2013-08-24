package bean;

import modelo.Produto;

public class ProdutoModel {
	private String codigo;
	private String nome;
	private String image;
	private Float valor;
	private ProdutoBean bean;
	
	public ProdutoModel() {
		super();
	}

	public ProdutoModel(Produto prod, ProdutoBean bean) {
		codigo = prod.getCodigo();
		nome = prod.getDescricao();
		image = prod.getImagem();
		valor = prod.getValor();
		this.bean = bean;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public ProdutoBean getBean() {
		return bean;
	}

	public void setBean(ProdutoBean bean) {
		this.bean = bean;
	}

	public String poeCarrinho() {
		bean.poeCarrinho(codigo);
		return "";
	}
}
