package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Funcionario;
import modelo.Telefone;
import modelo.dao.FuncionarioDao;

@ManagedBean(name = "cadastro")
@SessionScoped
public class Cadastro {
	private FuncionarioDao dao = FuncionarioDao.getInstance();

	private String nome;
	private String matricula;
	private String ddd = "11";
	private String telefone;

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

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getQuantos() {
		return dao.quantos();
	}
	
	public String salvar() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		boolean erro = false;

		if (nome.isEmpty()) {
			ctx.addMessage("form:nome", new FacesMessage(
					"O campo nome Ž obrigat—rio"));
			erro = true;
		}
		if (matricula.isEmpty()) {
			ctx.addMessage("form:matricula", new FacesMessage(
					"O campo matricula Ž obrigat—rio"));
			erro = true;
		}
		if (ddd.isEmpty()) {
			ctx.addMessage("form:ddd", new FacesMessage("O campo ddd Ž obrigat—rio"));
			erro = true;
		}
		if (telefone.isEmpty()) {
			ctx.addMessage("form:telefone", new FacesMessage(
					"O campo telefone Ž obrigat—rio"));
			erro = true;
		}

		if (!erro) {
			Funcionario obj = new Funcionario();
			obj.setNome(nome);
			obj.setMatricula(matricula);
			obj.getFones().add(new Telefone(ddd, telefone));

			dao.salvar(obj);

			ctx.addMessage("msg", new FacesMessage("Funcion‡rio Cadastrado"));
			
			nome = "";
			matricula = "";
			ddd = "11";
			telefone = "";
		}
		return "";
	}
}
