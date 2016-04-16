package faces;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import modelo.Fone;
import modelo.Funcionario;
import modelo.dao.CadastroDeFuncionario;
import modelo.dao.DaoException;

@ManagedBean(name = "func")
@RequestScoped
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CadFuncBean {
	@Size(min=6, max=25, message="deve ter entre 6 e 25 caracteres")
	private String nome;
	@Size(min=3, max=6, message="deve ter entre 3 e 6 digitos")
	private String matricula;
	@Pattern(regexp = "(9)?[0-9]{4}-[0-9]{4}", message = "inválido")
	private String telefone;
	private ListDataModel<FuncModel> dados = null;

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

	public void inclui() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		try {
			Funcionario func = new Funcionario();
			func.setNome(nome);
			Fone fone = new Fone(telefone);
			fone.setPessoa(func);
			func.getTelefones().add(fone);
			func.setMatricula(matricula);

			Funcionario achou = dao.localizaFuncionario(func.getNome());

			if (achou != null) {
				ctx.addMessage("form:nome",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "encontrada duplicidade", "O(A) Funcionario(a) ja esta cadastrado(a)!"));
			} else {
				dao.salvaFuncionario(func);

				nome = "";
				matricula = "";
				telefone = "";
			}
		} catch (DaoException ex) {
			System.out.println(ex.getMessage());
		} catch (ParseException ex) {
		}
	}

	public void apaga() {
		List<Funcionario> aDeletar = new ArrayList<Funcionario>();

		for (FuncModel f : (List<FuncModel>) dados.getWrappedData())
			if (f.isDel())
				aDeletar.add(new Funcionario(f.getId()));

		String msg = "";

		if (aDeletar.size() != 0) {
			try {
				dao.removeFuncinario(aDeletar);
				dados = null;
			} catch (DaoException ex) {
				msg = "Problemas na delecao dos Funcionarios!";
				FacesContext.getCurrentInstance().addMessage("form:geral", new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
			}
		}

	}

	public ListDataModel getDados() {
		if (dados == null) {
			List<FuncModel> lista = new ArrayList<FuncModel>();

			List<Funcionario> obj = dao.getLista();

			if (obj.size() > 0) {
				for (Funcionario f : obj) {
					lista.add(new FuncModel(f.getId(), f.getNome(), f.getMatricula()));
				}
			}
			return (dados = new ListDataModel<FuncModel>(lista));
		} else {
			return dados;
		}
	}
}
