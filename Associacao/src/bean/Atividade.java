package bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import dao.GerenteDeDados;

@ManagedBean
public class Atividade {
	@EJB
	private GerenteDeDados dao;
	private String nome;
	private Double valor;
	private boolean edita = false;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public boolean isEdita() {
		return edita;
	}

	public void setEdita(boolean edita) {
		this.edita = edita;
	}

	public String editar() {
		setEdita(true);
		return "";
	}

	public String naoEditar() {
		setEdita(false);
		return "";
	}

	public String grava() {
		edita = false;
		modelo.Atividade a = new modelo.Atividade();
		a.setNome(nome);
		a.setValor(valor);
		dao.grava(a);
		return "";
	}

}
