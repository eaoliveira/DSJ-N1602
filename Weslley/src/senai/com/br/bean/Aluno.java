package senai.com.br.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="aluno")
@NamedQuery(name="aluno.todos", query="select s from Aluno as s order by s.matricula")
public class Aluno implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matricula")
	private Integer matricula;
	private String nome;
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "idTurma", referencedColumnName = "idTurma")
	private Turma turma;
		

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
	
	public Turma getTurma() {
		return turma;
	}


	public void setTurma(Turma turma) {
		this.turma = turma;
	}


	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", email="
				+ email + ", idTurma=" + turma + "]";
	}

}
