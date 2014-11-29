package senai.com.br.bean;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Turma {
	
	@Id
	@GeneratedValue
	private Integer idTurma;
	private String titulo;
	private String descricao;
	
	@Temporal(TemporalType.DATE)
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

	@Override
	public String toString() {
		return "Turma [idTurma=" + idTurma + ", titulo=" + titulo
				+ ", descricao=" + descricao + ", inicio=" + inicio
				+ ", numHoras=" + numHoras + "]";
	}
	


}
