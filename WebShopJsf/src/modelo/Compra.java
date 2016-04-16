package modelo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Compra {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCompra")
	protected Integer id;
	protected String nome;
	protected String tipo;
	protected String cartao;
	protected String cod;
	protected Double valor;
	@OneToMany
	@JoinColumn(name = "idCompra")
	private List<ItemDeCompra> itens = new ArrayList<ItemDeCompra>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String value) {
		this.nome = value;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String value) {
		this.tipo = value;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String value) {
		this.cartao = value;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String value) {
		this.cod = value;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double value) {
		this.valor = value;
	}
	
	public List<ItemDeCompra> getItens() {
		return itens;
	}

	public void setItens(List<ItemDeCompra> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return String.format("Compra nº %s Por: %s Total: R$ %,.2f", id, nome,
				valor);
	}
}
