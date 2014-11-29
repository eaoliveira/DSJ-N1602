package sp.senai.org.br.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.CascadeType.REFRESH;
import javax.persistence.JoinColumn;

@Entity

public class Turma {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  Integer IdTurma ;
	private  String titulo;
	private  String descricao;
	private  Date inicio;
	private  Integer numHoras;
	@OneToMany(orphanRemoval = true, cascade = { REMOVE, REFRESH })
	@JoinColumn(name = "idTurma", nullable = false)
	private List<Turma> alunos;
	  
	public Integer getIdTurma() {
		return IdTurma;
	}
	public void setIdturma(Integer idTurma) {
		this.IdTurma = idTurma;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Integer getNumHoras() {
		return numHoras;
	}
	public void setNumHoras(Integer numHoras) {
		this.numHoras = numHoras;
	}
	public List<Turma> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Turma> alunos) {
		this.alunos = alunos;
	}
	  
	  
}

