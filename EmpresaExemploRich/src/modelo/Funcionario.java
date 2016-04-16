package modelo;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public  class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idFuncionario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id = 0;
	private String nome = "";
	private String matricula = "";
	@OneToMany(mappedBy = "funcionario", cascade = ALL,fetch=FetchType.EAGER)
	private Set<Fone> telefones = new HashSet<Fone>();

	public Funcionario() {}
	
	public Funcionario(Integer id) {
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

	public Set<Fone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Fone> telefones) {
		this.telefones = telefones;
	}

	@Override
	public boolean equals(Object obj) {
		boolean eIgual = true;

		if (!(obj instanceof Funcionario))
			eIgual = false;
		else {
			Funcionario o = (Funcionario) obj;
			eIgual = this.getNome().equals(o.getNome());
		}
		return eIgual;
	}

	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}

	@Override
	public String toString() {
		return "Nome: " + getNome() 
				+ "\nTelefones:\n" + getTelefones()
				+ "\nMatric: " + getMatricula();
	}
}
