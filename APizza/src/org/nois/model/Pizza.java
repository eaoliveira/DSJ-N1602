package org.nois.model;

import java.io.Serializable;

public class Pizza implements Serializable {
	private static final long serialVersionUID = -4626626445612834701L;

	protected Integer id;
	protected String nome;
	protected String grupo;
	protected String descricao;
	protected String imagemGrande;
	protected String imagemPequena;
	protected Double preco;

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

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String value) {
		this.grupo = value;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String value) {
		this.descricao = value;
	}

	public String getImagemGrande() {
		return imagemGrande;
	}

	public void setImagemGrande(String value) {
		this.imagemGrande = value;
	}

	public String getImagemPequena() {
		return imagemPequena;
	}

	public void setImagemPequena(String value) {
		this.imagemPequena = value;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double value) {
		this.preco = value;
	}

	@Override
	public String toString() {
		return "id: " + id + " nome: " + nome + " grupo: " + grupo
				+ " descricao: " + descricao + " imagemGrande: " + imagemGrande
				+ " imagemPequena: " + imagemPequena + " preco: " + preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((imagemGrande == null) ? 0 : imagemGrande.hashCode());
		result = prime * result
				+ ((imagemPequena == null) ? 0 : imagemPequena.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
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
		Pizza other = (Pizza) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imagemGrande == null) {
			if (other.imagemGrande != null)
				return false;
		} else if (!imagemGrande.equals(other.imagemGrande))
			return false;
		if (imagemPequena == null) {
			if (other.imagemPequena != null)
				return false;
		} else if (!imagemPequena.equals(other.imagemPequena))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		return true;
	}

}
