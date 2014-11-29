package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Column;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
public class Turma implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idTurma")
	private Integer id;
	private String Titulo;
	private String Descricao;
	@Temporal(DATE)
	private Date DatadeInicio;
	private int NumerodeHoras;
	@OneToMany
	@JoinColumn(name = "idTurma", nullable = false)
	private List<Aluno> alunos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public Date getDatadeInicio() {
		return DatadeInicio;
	}
	public void setDatadeInicio(Date datadeInicio) {
		DatadeInicio = datadeInicio;
	}
	public int getNumerodeHoras() {
		return NumerodeHoras;
	}
	public void setNumerodeHoras(int numerodeHoras) {
		NumerodeHoras = numerodeHoras;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	

}
