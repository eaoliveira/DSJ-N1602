package bean;

import modelo.Funcionario;

public class FuncionarioModel {
	private Integer id;
	private String nome;
	private String matricula;
	private boolean del;

	
	public FuncionarioModel() {
		super();
	}

	public FuncionarioModel(Funcionario obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.matricula = obj.getMatricula();
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
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

}
