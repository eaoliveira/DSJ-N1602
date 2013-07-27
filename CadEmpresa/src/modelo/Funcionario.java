package modelo;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
	private Integer id;
	private String nome;
	private String matricula;
	private List<Telefone> fones = new ArrayList<Telefone>();

	public Funcionario() {
		super();
	}

	public Funcionario(Integer id) {
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Telefone> getFones() {
		return fones;
	}

	public void setFones(List<Telefone> lista) {
		this.fones = lista;
	}

	@Override
	public String toString() {
		return "id:  " + id + "  nome:  " + nome + "  matricula:  " + matricula
				+ "  lista:  " + fones;
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
