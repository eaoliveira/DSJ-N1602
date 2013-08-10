package bean;

import modelo.Contato;

public class ContatoModel {
	private Integer id;
	private String nome;
	private int idade;
	private String email;
	private boolean del;

	
	public ContatoModel() {
		super();
	}

	public ContatoModel(Contato obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.idade = obj.getIdade();
		this.email = obj.getEmail();
		this.del = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

}
