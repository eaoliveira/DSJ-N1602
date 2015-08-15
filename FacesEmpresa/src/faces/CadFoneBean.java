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
import javax.faces.model.SelectItem;

import modelo.Fone;
import modelo.Funcionario;
import modelo.dao.CadastroDeFuncionario;
import modelo.dao.DaoException;

@ManagedBean(name="fone")
@SessionScoped
public class CadFoneBean {
	@EJB
	CadastroDeFuncionario dao;
	private String ddd = "";
	private String numero = "";
	private Integer func = new Integer(-1);
	protected Collection<SelectItem> funcLista = null;
	
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
		return func;
	}

	public void setFunc(Integer func) {
		this.func = func;
	}

	public int getFoneCount() {
		return dao.getLista().size();
	}

	@SuppressWarnings({ "rawtypes" })
	public Collection getFuncLista() {
		funcLista = new ArrayList<SelectItem>();

		try {
			List<Funcionario> obj = dao.getLista();

			if (obj.size() > 0 && getFunc() == -1)
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
		return dao.localizaFuncionarioPeloId(this.func).getTelefones().size() > 0;
	}

	public String inclui() {
		String msg = "";
		String destino = "erro";

		try {
			Fone fone = new Fone();
			fone.setDdd(ddd);
			fone.setNumero(numero);

			if (fone.getNumero().equals("")) {
				msg = "O campo número deve ser preenchido!";
			} else {
				Funcionario func = dao.localizaFuncionarioPeloId(this.func);

				if (func == null) {
					msg = "O(A) Funcionário(a) não está cadastrado(a)!";
				} else {
					func.getTelefones().add(fone);
					fone.setPessoa(func);
					dao.salvaFuncionario(func);

					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									"Sucesso na gravação!", "Sucesso na gravação!"));

					setDdd("");
					setNumero("");

					destino = "sucesso";
				}
			}
		} catch (java.text.ParseException ex) {
			msg = ex.getMessage();
		} catch (DaoException ex) {
			msg = "Problemas na gravação!" + ex.getMessage();
		}

		if (destino.equals("erro")) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}

		return destino;
	}

	public String invalida() {
		func = -1;
		return "menu";
	}
}