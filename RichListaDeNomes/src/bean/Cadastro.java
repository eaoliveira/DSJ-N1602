package bean;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import dados.Dao;

@ManagedBean
public class Cadastro {
	private Dao dao = Dao.getInstance();
	
	@Null(message = "O Nome deve ser informado")
	@Size(min=3, message="Nome inválido")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void salvar() {
		dao.salva(nome);

		nome = "";
	}

}
