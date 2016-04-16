package faces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.validation.constraints.Pattern;

import modelo.Fone;
import modelo.Funcionario;
import modelo.dao.CadastroDeFuncionario;
import modelo.dao.DaoException;

@ManagedBean(name = "fone")
@SessionScoped
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CadFoneBean {
	@Pattern(regexp = "[1-9]{2}", message = "inválido")
	private String ddd = "";
	@Pattern(regexp = "(9)?[0-9]{4}-[0-9]{4}", message = "inválido")
	private String numero = "";
	private Integer funcId;
	protected Collection<SelectItem> funcLista = null;
	private ListDataModel<FoneModel> dados;

	@EJB
	private CadastroDeFuncionario dao;

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

	public Integer getFunc() {
		return funcId;
	}

	public void setFunc(Integer func) {
		this.funcId = func;
	}

	public int getFoneCount() {
		return dao.getLista().size();
	}

	public Collection getFuncLista() {
		funcLista = new ArrayList<SelectItem>();

		try {
			List<Funcionario> obj = dao.getLista();

			if (obj.size() > 0 && getFunc() == null)
				setFunc(obj.get(0).getId());

			for (Funcionario f : obj)
				funcLista.add(new SelectItem(f.getId(), f.getNome()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return funcLista;
	}

	public void funcChanged(ValueChangeEvent ev) {
		setFunc((Integer) ev.getNewValue());
	}

	public boolean getTemFone() {
		return dao.localizaFuncionarioPeloId(this.funcId).getTelefones().size() > 0;
	}

	public String inclui() {
		String msg = "";
		String destino = "erro";

		try {
			Fone fone = new Fone();
			fone.setDdd(ddd);
			fone.setNumero(numero);

			Funcionario func = dao.localizaFuncionarioPeloId(this.funcId);

			if (func == null) {
				msg = "O(A) Funcionário(a) não está cadastrado(a)!";
			} else {
				func.getTelefones().add(fone);
				fone.setPessoa(func);
				dao.salvaFuncionario(func);

				setDdd("");
				setNumero("");

				destino = "sucesso";
			}
		} catch (java.text.ParseException ex) {
			msg = ex.getMessage();
		} catch (DaoException ex) {
			msg = "Problemas na gravação!" + ex.getMessage();
		}

		if (destino.equals("erro")) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}

		return destino;
	}

	public String apaga() {
		List<Fone> aDeletar = new ArrayList<Fone>();

		for (FoneModel f : (List<FoneModel>) dados.getWrappedData())
			if (f.isDel())
				aDeletar.add(new Fone(f.getId()));

		String msg = "";

		if (aDeletar.size() != 0) {
			try {
				dao.removeFone(funcId, aDeletar);
				msg = "Telefones deletados!";
				dados = null;
			} catch (DaoException ex) {
				msg = "Problemas na delecao dos Telefones!";
			}
		} else {
			msg = "Nao existem itens selecionados!";
		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));

		return "fim";
	}

	public ListDataModel<FoneModel> getDados() {
		if (dados == null) {
			List<FoneModel> lista = new ArrayList<FoneModel>();

			Funcionario func = dao.localizaFuncionarioPeloId(funcId);

			if (func != null) {
				java.util.Set<Fone> obj = func.getTelefones();

				if (obj.size() != 0) {
					for (Fone f : obj)
						lista.add(new FoneModel(f.getId(), f.getDdd(), f.getNumero()));
				}
			}
			return (dados = new ListDataModel<FoneModel>(lista));
		} else {
			return dados;
		}
	}
}