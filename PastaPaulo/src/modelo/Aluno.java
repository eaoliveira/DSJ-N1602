package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="alunos")
public class Aluno implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAlunos")
	private Integer id;
	private String Nome;
	private String Email;
	private String NumdeMatricula;
	private Turma TurmaaCursar;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getNumdeMatricula() {
		return NumdeMatricula;
	}
	public void setNumdeMatricula(String numdeMatricula) {
		NumdeMatricula = numdeMatricula;
	}
	public Turma getTurmaaCursar() {
		return TurmaaCursar;
	}
	public void setTurmaaCursar(Turma turmaaCursar) {
		TurmaaCursar = turmaaCursar;
	}
	
	
 
	
	
}
