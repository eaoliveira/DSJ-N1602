package br.senai.sp.caseiros.modelo;

import java.util.Date;

public class Produto implements Comparable<Produto>{
	private Integer id;
	private String nome;
	private String desc;
	private Date validade;
	private double preco;

	public Produto() {
		super();
	}

	public Produto(Integer id) {
		super();
		this.id = id;
	}

	public Produto(String nome) {
		super();
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "id: " + id + " nome: " + nome + " desc: " + desc
				+ " validade: " + validade + " preco: " + preco;
	}


	@Override
	public int hashCode() {
		final int prime = 982734;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public int compareTo(Produto o) {
		return nome.compareTo(o.nome);
	}

}
