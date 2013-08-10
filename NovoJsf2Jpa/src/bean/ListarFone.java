package bean;

import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import modelo.Contato;
import modelo.Fone;
import dao.NovoGerente;

@ManagedBean(name = "listaFone")
public class ListarFone {
	private String nome;
	private String email;
	private ListDataModel<FoneModel> dados;
	private Integer idContato;
	// @EJB
	private NovoGerente dao;

	public ListarFone() {
		try {
			InitialContext ic = new InitialContext();
			dao = (NovoGerente) ic.lookup("java:module/NovoGerente");
			FacesContext ctx = FacesContext.getCurrentInstance();
			ELContext ex = ctx.getELContext();
			ValueExpression ve = ctx.getApplication().getExpressionFactory()
					.createValueExpression(ex, "#{fone}", CadFone.class);
			CadFone managedBean = (CadFone) ve.getValue(ex);
			idContato = managedBean.getIdContato();
			Contato obj = dao.localize(idContato);
			nome = obj.getNome();
			email = obj.getEmail();
		} catch (NamingException ex) {
			ex.printStackTrace(System.out);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ListDataModel<FoneModel> getDados() {

		List<FoneModel> model = new ArrayList<FoneModel>();

		for (Fone obj : dao.localize(idContato).getFones()) {
			model.add(new FoneModel(obj));
		}

		dados = new ListDataModel<FoneModel>(model);
		return dados;
	}

	public void setDados(ListDataModel<FoneModel> dados) {
		this.dados = dados;
	}

	public String apagar() {
		@SuppressWarnings("unchecked")
		List<FoneModel> model = (List<FoneModel>) dados.getWrappedData();

		for (FoneModel obj : model) {
			if (obj.isDel()) {
				dao.remove(idContato, obj.getId());
			}
		}

		return "";
	}
}
