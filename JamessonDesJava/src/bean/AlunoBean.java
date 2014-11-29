package bean;

import java.util.List;

public class AlunoBean {
	private List<AlunoBean> itens; // Uma lista da class 
	private String nome;
	private String email;
	private Integer numMatricula;
	private TurmaBean turma;
	
	public AlunoBean(List<AlunoBean> obj) { //contrutor recebendo uma lista de Alunos
		itens = obj;
	}
	
	public List<AlunoBean> getItens() {//Get comum
		return itens;
	}
	
	public int getCount() {//Contator
		return itens.size();
	}

	
	//Get e Set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(Integer numMatricula) {
		this.numMatricula = numMatricula;
	}

	public TurmaBean getTurma() {
		return turma;
	}

	public void setTurma(TurmaBean turma) {
		this.turma = turma;
	}
	
	
	
	
	
	
	
}
