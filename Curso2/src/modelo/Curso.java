package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="curso")
@NamedQueries({
	@NamedQuery(name="todosCursos", query="select obj from Curso as obj")
})
public class Curso {
	@Id
	@Column(name="idcurso")
	private int Id;
	private String nome;
	private String descr;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
	public String toString() {
		return "Id: " + Id + " nome: " + nome + " descr: " + descr;
	}

}
