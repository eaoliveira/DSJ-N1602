package faces;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import modelo.Fone;
import modelo.Funcionario;
import modelo.dao.CadastroDeFuncionario;

@ManagedBean(name="func")
@RequestScoped
public class CadFuncBean {
	private String nome = "";
	private String matricula = "";
	private String telefone = "";
	private String mensagem = "";
	private String destino = "";
	
	@EJB
	CadastroDeFuncionario dao;

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public String inclui() {
		try {
			Funcionario func = new Funcionario();
			func.setNome(nome);
			Fone fone = new Fone(telefone);
			fone.setPessoa(func);
			func.getTelefones().add(fone);
			func.setMatricula(matricula);

			if (func.getNome().isEmpty() && func.getMatricula().isEmpty()) {
				setMensagem("Os campos nome, e matricula "
						+ "devem ser preenchidos!");
				destino = "erro";
			} else {
				Funcionario achou = 
					dao.localizaFuncionario(func.getNome());

				if (achou != null) {
					setMensagem("O(A) Funcionario(a) ja esta cadastrado(a)!");
					destino = "erro";
				} else {
					dao.salvaFuncionario(func);

					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									"Sucesso na gravacao!", "Sucesso na gravacao!"));
					destino = "sucesso";

					nome = "";
					matricula = "";
					telefone = "";
				}
			}
		} catch (Exception ex) {
			setMensagem(ex.getMessage());
			destino = "erro";
		}

		if (destino.equals("erro")) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							getMensagem(), getMensagem()));
		}

		return destino;
	}
}
