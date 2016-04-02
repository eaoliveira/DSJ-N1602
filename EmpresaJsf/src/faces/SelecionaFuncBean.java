package faces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import modelo.Fone;
import modelo.Funcionario;
import modelo.dao.CadastroDeFuncionario;
import modelo.dao.DaoException;

@ManagedBean(name="selecionaFunc")
@SessionScoped
public class SelecionaFuncBean {
	@EJB
	private CadastroDeFuncionario dao;
	
	private Integer funcionario;
	
	private Funcionario obj;
	
	private String nome;
	private ListDataModel<Fone> fones;
	
	private String mensagem;
	private String titulo;
	
	public Integer getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Integer funcionario) {
		this.funcionario = funcionario;
	}
	
	public List<Funcionario> getFuncionarios() {
		return dao.getLista();
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public String getNome() {
		nome = obj.getNome();
		return nome;
	}

	public ListDataModel<Fone> getFones() {
		fones = new ListDataModel<Fone>(new ArrayList<>(obj.getTelefones()));
		return fones;
	}

	public String seleciona() {
		obj = dao.localizaFuncionarioPeloId(funcionario);
		return "listaTelefones.xhtml";
	}
	
	public void reset() {
		titulo = null;
		mensagem = null;
	}
	
	@SuppressWarnings("unchecked")
	public void remover() {
		for (Fone fone : (List<Fone>)fones.getWrappedData()) {
			if(fone.isDel()) {
				obj.getTelefones().remove(fone);
			}
		}
		try {
			dao.salvaFuncionario(obj);
			titulo = "Sucesso";
			mensagem = "Telefone(s) excluídos";
		} catch(DaoException ex) {
			titulo = "Falha";
			mensagem = "Problema na exclusão de telefones";
		}
	}
}
