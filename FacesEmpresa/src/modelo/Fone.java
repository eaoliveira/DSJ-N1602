package modelo;

import java.io.Serializable;
import java.text.ParseException;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "telefone")
public class Fone implements Serializable, Cloneable, Comparable<Fone> {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idFone")
	private Integer id = 0;
	private String ddd = "";
	private String numero = "";
	@ManyToOne
	@JoinColumn(name = "idFuncionario")
	private Funcionario funcionario;

	public Fone() {
		numero = "0000-0000";
		ddd = "00";
	}

	public Fone(String fone) throws ParseException {
		ddd = "11";
		setNumero(fone);
	}

	public Fone(String ddd, String fone) throws ParseException {
		setDdd(ddd);
		setNumero(fone);
	}

	public Fone(Fone fone) throws ParseException {
		setDdd(new String(fone.getDdd()));
		setNumero(new String(fone.getNumero()));
	}

	public Fone(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) throws ParseException {
		if (!Pattern.matches("[0-9]{1,3}", ddd))
			throw new ParseException("Nº de DDD inválido!", 0);
		else
			this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) throws ParseException {
		if (!Pattern.matches("[0-9]{3,4}-[0-9]{4}", numero))
			throw new ParseException("Nº de telefone inválido!", 0);
		else
			this.numero = numero;
	}
	
	public Funcionario getPessoa() {
		return funcionario;
	}

	public void setPessoa(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public int hashCode() {
		final int COD_BASE = 123;
		int codigo = COD_BASE;

		if (ddd != null)
			codigo *= COD_BASE + ddd.hashCode();

		if (numero != null)
			codigo *= COD_BASE + numero.hashCode();

		return codigo;
	}

	public int compareTo(Fone obj) {
		int ret = 0;

		if ((ret = ddd.compareTo(obj.getDdd())) != 0)
			return ret;
		else
			return numero.compareTo(obj.getNumero());
	}

	public boolean equals(Object obj) {
		boolean ret = false;

		if (obj instanceof Fone) {
			Fone f = (Fone) obj;

			ret = f.getDdd().equals(this.getDdd())
					&& f.getNumero().equals(this.getNumero());
		}

		return ret;
	}

	public String toString() {
		return String.format("Fone: (%03d) %s", Integer.valueOf(getDdd()),
				getNumero());
	}

	public Object clone() throws CloneNotSupportedException {
		try {
			return new Fone(this);
		} catch (ParseException e) {
			throw new CloneNotSupportedException();
		}
	}

}
