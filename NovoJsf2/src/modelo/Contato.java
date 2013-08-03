package modelo;

import java.util.ArrayList;
import java.util.List;

public class Contato implements Comparable<Contato>{
	private Integer id;
	private String nome;
	private int idade;
	private String email;
	private List<Fone> fones = new ArrayList<Fone>();
	
	public Contato() {
		super();
	}

	public Contato(Integer id) {
		super();
		this.id = id;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Fone> getFones() {
		return fones;
	}

	public void setFones(List<Fone> fones) {
		this.fones = fones;
	}

	public String toString() {
		String msg = String.format("Nome: %s Idade: %d E-Mail: %s\nFones:\n", nome, idade,
				email);
		for (Fone obj : fones) {
			msg += obj + "\n";
		}
		return msg;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
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
		Contato other = (Contato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(Contato outro) {
		return nome.compareTo(outro.nome);
	}


}
