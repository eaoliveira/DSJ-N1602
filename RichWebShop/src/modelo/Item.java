package modelo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@Column(name = "idItem")
	@GeneratedValue(strategy = IDENTITY)
	protected Integer id;
	protected String codigo;
	protected String descricao;
	protected Float valor;
	protected String imagem;
	protected Integer quantidade;
	@ManyToOne
	@JoinColumn(name = "idCarrinho")
	protected Carrinho carrinho;

	public Item() {
	}

	public Item(Produto prod) {
		codigo = new String(prod.codigo);
		descricao = new String(prod.descricao);
		valor = new Float(prod.valor);
		imagem = new String(prod.imagem);
		quantidade = 1;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String value) {
		this.codigo = value;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String value) {
		this.descricao = value;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float value) {
		this.valor = value;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String value) {
		this.imagem = value;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer value) {
		this.quantidade = value;
	}
	
	public double getTotal() {
		return quantidade * valor;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	@Override
	public String toString() {
		return "id:  " + id + "  codigo:  " + codigo + "  descricao:  "
				+ descricao + "  valor:  " + valor + "  imagem:  " + imagem
				+ "  quantidade:  " + quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
