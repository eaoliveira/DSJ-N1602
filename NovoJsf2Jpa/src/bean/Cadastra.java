package bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Contato;
import dao.NovoGerente;

@ManagedBean(name = "entrada")
@SessionScoped
public class Cadastra {
	private String nome;
	private int idade;
	private String email;
	@EJB
	private NovoGerente dao;
	
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

	public int getQtdCadastrado() {
		return dao.size();
	}
	
	public String enviar() {
		Contato obj = new Contato();
		obj.setNome(nome);
		obj.setIdade(idade);
		obj.setEmail(email);
		dao.salvar(obj);
		
		System.out.println(obj);
		nome = "";
		idade = 0;
		email= "";

		FacesMessage msg = new FacesMessage("Dados Gravados Com Sucesso"); 
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, msg);
		
		return "";
	}
}
