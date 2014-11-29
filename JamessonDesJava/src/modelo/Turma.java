package modelo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

//Parte do JPA

@Entity
public class Turma  implements Serializable  {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer idTurma;
	private String titulo;
	private String descricao;
	private Date inicio;
	private Integer numHoras;
	
	public Integer getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
