package faces;

import java.text.ParseException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.Fone;
import modelo.Funcionario;
import modelo.dao.CadastroDeFuncionario;
import modelo.dao.DaoException;

@ManagedBean(name = "telefone")
@SessionScoped
public class TelefoneBean {
	@EJB
	private CadastroDeFuncionario dao;

	private String ddd;
	private String numero;

	private Integer funcionario;

	private String mensagem;
	private String titulo;

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Integer funcionario) {
		this.funcionario = funcionario;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Funcionario> getFuncionarios() {
		return dao.getLista();
	}
	
	public void reset() {
		titulo = null;
		mensagem = null;
	}
	
	public void salvar() {
		try {
			Funcionario func = dao.localizaFuncionarioPeloId(funcionario);
			
			Fone fone = new Fone();
			fone.setDdd(ddd);
			fone.setNumero(numero);
			fone.setPessoa(func);
			
			func.getTelefones().add(fone);
			
			dao.salvaFuncionario(func);
			
			ddd = "";
			numero = "";
			
			titulo = "Sucesso";
			mensagem = "O Telefone foi adicionado";
		} catch (DaoException ex) {
			titulo = "Erro";
			mensagem = "Não foi possível gravar o Telefone";
		} catch (ParseException ex) {
			titulo = "Dados Inválidos";
			mensagem = ex.getMessage();
		}
	}

	public void remover() {

	}
}
