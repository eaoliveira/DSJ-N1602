package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

import modelo.Funcionario;
import modelo.dao.FuncionarioDao;

@ManagedBean(name="listaBean")
public class Listar {
	private ListDataModel<FuncionarioModel> dados;
	
	private FuncionarioDao dao = FuncionarioDao.getInstance();
	
	public ListDataModel<FuncionarioModel> getDados() {
		List<FuncionarioModel> model = new ArrayList<FuncionarioModel>();
		
		for (Funcionario obj : dao.getDados()) {
			model.add(new FuncionarioModel(obj));
		}
		
		dados = new ListDataModel<FuncionarioModel>(model);
		return dados;
	}
	
	public void setDados(ListDataModel<FuncionarioModel> dados) {
		this.dados = dados;
	}
	
	public String apagar() {
		@SuppressWarnings("unchecked")
		List<FuncionarioModel> model = (List<FuncionarioModel>)dados.getWrappedData();
		
		for (FuncionarioModel obj : model) {
			if(obj.isDel()) {
				dao.remover(obj.getId());
			}
		}
		
		return "";
	}
}
