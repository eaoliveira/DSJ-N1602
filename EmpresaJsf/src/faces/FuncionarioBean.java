package faces;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

import java.util.ArrayList;
import java.util.List;

import modelo.Funcionario;
import modelo.dao.CadastroDeFuncionario;
import modelo.dao.DaoException;

@ManagedBean(name="funcionario")
public class FuncionarioBean {
	@EJB
	private CadastroDeFuncionario dao;
	
	private String nome;
	private String matricula;
	
	private ListDataModel<Funcionario> lista;
	
	private String mensagem;
	private String titulo;

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
	
	public String getMensagem() {
		return mensagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public ListDataModel<Funcionario> getLista() {
		lista = new ListDataModel<Funcionario>(dao.getLista());
		return lista;
	}
		
	public void salvar() {
		try {
			Funcionario obj = new Funcionario();
			obj.setNome(nome);
			obj.setMatricula(matricula);
			dao.salvaFuncionario(obj);
			nome = "";
			matricula = "";
			titulo = "Sucesso";
			mensagem = "Os dados do funcionários foram gravados";
		} catch (DaoException ex) {
			titulo = "Erro";
			mensagem = "Não foi possível gravar os dados de Funcionário";
		}
	}

	@SuppressWarnings("unchecked")
	public void remover() {
		List<Funcionario> itens = (List<Funcionario>)lista.getWrappedData();
		List<Funcionario> aRemover = new ArrayList<>();
		
		for (Funcionario funcionario : itens) {
			if(funcionario.isDel()) {
				aRemover.add(funcionario);
			}
		}
		try {
			dao.removeFuncinario(aRemover);
			titulo = "Sucesso";
			mensagem = "Funcionário(s) removido(s)";
		} catch(DaoException ex) {
			titulo = "Falha";
			mensagem = "Erro ao excluir dados de Funcionário(s)";
		}
	}
}
