package bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

import dao.GerenteDeDados;

@ManagedBean
public class Associado {
	@EJB
	private GerenteDeDados dao;
	private String nome;
	private String endereco;
	private Integer idade;
	private String telefone;
	private String email;
	private boolean edita = false;

	public GerenteDeDados getDao() {
		return dao;
	}

	public void setDao(GerenteDeDados dao) {
		this.dao = dao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		modelo.Associado a = new modelo.Associado();
		a.setNome(nome);
		a.setEndereco(endereco);
		a.setIdade(idade);
		a.setTelefone(telefone);
		a.setEmail(email);
		dao.grava(a);
		return "";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ListDataModel<modelo.Associado> getLista() {
		return new ListDataModel(dao.getAssociados());
	}
}
