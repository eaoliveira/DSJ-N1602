package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

import modelo.Contato;
import dao.GerenciaContatos;

@ManagedBean(name="listaBean")
public class Listar {
	private ListDataModel<ContatoModel> dados;
	
	private GerenciaContatos dao = GerenciaContatos.getInstance();
	
	public ListDataModel<ContatoModel> getDados() {
		List<ContatoModel> model = new ArrayList<ContatoModel>();
		
		for (Contato obj : dao.getContatos()) {
			model.add(new ContatoModel(obj));
		}
		
		dados = new ListDataModel<ContatoModel>(model);
		return dados;
	}
	
	public void setDados(ListDataModel<ContatoModel> dados) {
		this.dados = dados;
	}
	
	public String apagar() {
		@SuppressWarnings("unchecked")
		List<ContatoModel> model = (List<ContatoModel>)dados.getWrappedData();
		
		for (ContatoModel obj : model) {
			if(obj.isDel()) {
				dao.remove(obj.getId());
			}
		}
		
		return "";
	}
}
