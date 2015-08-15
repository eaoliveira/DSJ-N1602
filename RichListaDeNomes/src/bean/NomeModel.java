package bean;

import model.Nomes;

public class NomeModel {
	private Integer id;
	private String nome;
	private boolean del;

	public NomeModel() { }
	
	public NomeModel(Nomes obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
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

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}
}
