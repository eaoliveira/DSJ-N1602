package model;

import static javax.persistence.FetchType.EAGER;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="Turma")
@NamedQuery(name="turma.todas", query="select t from Turma as t")
public class Turma implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idTurma")
	private int id;

	private String descricao;

    @Temporal( TemporalType.DATE)
	private Date inicio;
	
	@Column(name="numHoras")
    private int horas;

	private String titulo;

	//bi-directional many-to-one association to Aluno
	@OneToMany(mappedBy="turma", fetch = EAGER, orphanRemoval = true, cascade = ALL)
	private List<Aluno> alunos;

    public Turma() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int idturma) {
		this.id = idturma;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getInicio() {
		return this.inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public int getNumhoras() {
		return this.horas;
	}

	public void setNumhoras(int horas) {
		this.horas = horas;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}