package faces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import modelo.Fone;
import modelo.Funcionario;
import modelo.dao.CadastroDeFuncionario;
import modelo.dao.DaoException;

@ManagedBean(name = "foneLista")
@RequestScoped
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ListaFoneBean {
	private String nome = "";
	private Integer id = null;
	private ListDataModel dados = null;
	@EJB
	CadastroDeFuncionario dao;

	public ListaFoneBean() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ELContext elc = fc.getELContext();
		ValueExpression ve = fc.getApplication().getExpressionFactory()
				.createValueExpression(elc, "#{fone}", CadFoneBean.class);
		CadFoneBean cfb = (CadFoneBean) ve.getValue(elc);
		id = cfb.getFunc();

		Funcionario func = null;

		try {
			func = dao.localizaFuncionarioPeloId(id);

			if (func != null)
				setNome(func.getNome());
		} catch (Exception ex) {
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String deleta() {
		List<Fone> aDeletar = new ArrayList<Fone>();

		for (FoneModel f : (List<FoneModel>) dados.getWrappedData())
			if (f.isDel())
				aDeletar.add(new Fone(f.getId()));

		String msg = "";

		if (aDeletar.size() != 0) {
			try {
				dao.removeFone(id, aDeletar);
				msg = "Telefones deletados!";
				dados = null;
			} catch (DaoException ex) {
				msg = "Problemas na delecao dos Telefones!";
			}
		} else {
			msg = "Nao existem itens selecionados!";
		}

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));

		return "fim";
	}

	public boolean getTemFone() {
		return dao.localizaFuncionarioPeloId(id).getTelefones().size() > 0;
	}

	public ListDataModel getDados() {
		if (dados == null) {
			List<FoneModel> lista = new ArrayList<FoneModel>();

			Funcionario func = dao.localizaFuncionarioPeloId(id);

			java.util.Set<Fone> obj = func.getTelefones();

			if (obj.size() != 0) {
				for (Fone f : obj)
					lista.add(new FoneModel(f.getId(), f.getDdd(), f.getNumero()));
			}
			return (dados = new ListDataModel(lista));
		} else {
			return dados;
		}
	}

	public String invalida() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ELContext elc = fc.getELContext();
		ValueExpression ve = fc.getApplication().getExpressionFactory()
				.createValueExpression(elc, "#{fone}", CadFoneBean.class);
		CadFoneBean cfb = (CadFoneBean) ve.getValue(elc);
		cfb.setFunc(-1);

		return "menu";
	}
}