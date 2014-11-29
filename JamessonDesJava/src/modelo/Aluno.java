package modelo;

import java.io.Serializable;



import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

//Parte do JPA



@Entity
public class Aluno  implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@OneToMany
	@JoinColumn(name = "idTurma")
	private Set<Turma> idTurma = new TreeSet<Turma>();
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer matricula;
	private String nome;
	private String email;

	
	
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Turma> getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(TreeSet<Turma> idTurma) {
		this.idTurma = idTurma;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
