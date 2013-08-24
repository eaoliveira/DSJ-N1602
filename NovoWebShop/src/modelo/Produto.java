package modelo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import dao.ShopException;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@Column(name = "idProduto")
	@GeneratedValue(strategy = IDENTITY)
	protected Integer id;
	protected String codigo;
	protected String descricao;
	protected Float valor;
	protected String imagem;
	protected Integer quantidade;
	protected Integer reservado;

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

	public Integer getReservado() {
		return reservado;
	}

	public void setReservado(Integer reservado) {
		this.reservado = reservado;
	}

	@Override
	public String toString() {
		return "id:  " + id + "  codigo:  " + codigo + "  descricao:  "
				+ descricao + "  valor:  " + valor + "  imagem:  " + imagem
				+ "  quantidade:  " + quantidade + "  reservado:  " + reservado;
	}

	public void reserva(int qtd) throws ShopException {
		if(getQtdEstoque() >= qtd)
			reservado += qtd;
		else
			throw new ShopException("Estoque Esgotado!");
	}
	
	public int getQtdEstoque() {
		return quantidade - reservado;
	}
}
