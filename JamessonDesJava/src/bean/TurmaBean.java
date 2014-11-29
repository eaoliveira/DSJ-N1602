package bean;

import java.util.Date;
import java.util.List;

import modelo.Turma;



public class TurmaBean {
	private List<Turma> itens; // Uma lista da class 
	private String titulo;
	private String descricao;
	private Date dataInicio;
	private Integer numeroHoras;
	
	public TurmaBean(List<Turma> list) { //construtor recebendo uma lista de Turma
		itens = list;
	}
	
	
	public List<Turma> getItens() {//Get comum
		return itens;
	}
	
	public int getCount() {//Contator
		return itens.size();
	}

	//get e set
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Integer getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(Integer numeroHoras) {
		this.numeroHoras = numeroHoras;
	}




}
