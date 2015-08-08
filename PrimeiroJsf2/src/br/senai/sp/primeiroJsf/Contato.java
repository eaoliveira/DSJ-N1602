package br.senai.sp.primeiroJsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Contato {
	private Integer id;
	private String nome;
	private String email;
	private String telefone;
	private boolean del;
	private boolean emEdicao;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}
	
	public boolean isEmEdicao() {
		return emEdicao;
	}

	public void setEmEdicao(boolean emEdicao) {
		this.emEdicao = emEdicao;
	}

	public String salvar() {
		Contato con = new Contato();
		con.setNome(nome);
		con.setEmail(email);
		con.setTelefone(telefone);
		Dao.getInstance().salvar(con);
		nome = "";
		email = "";
		telefone = "";
		return "";
	}

	public void editar() {
		emEdicao = true;
	}

	@Override
	public String toString() {
		return "id: " + id + " nome: " + nome + " email: " + email
				+ " telefone: " + telefone;
	}
	
}
