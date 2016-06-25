package modelo;

public class Curso {
	private Integer Id;
	private String nome;
	private String descr;

	public Integer getId() {
		return Id;
	}

	public Curso setId(Integer id) {
		Id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Curso setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getDescr() {
		return descr;
	}

	public Curso setDescr(String descr) {
		this.descr = descr;
		return this;
	}

	@Override
	public String toString() {
		return "Id: " + Id + " nome: " + nome + " descr: " + descr;
	}

}
