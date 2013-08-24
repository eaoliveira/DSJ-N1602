package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Carrinho {
	@Id
	@Column(name = "idCarrinho")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String sessao;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCarrinho")
	private List<Item> itens = new ArrayList<Item>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSessao() {
		return sessao;
	}

	public void setSessao(String sessao) {
		this.sessao = sessao;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "id:  " + id + "  sessao:  " + sessao + "  itens:  " + itens;
	}

}
