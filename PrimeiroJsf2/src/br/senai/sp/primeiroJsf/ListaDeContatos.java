package br.senai.sp.primeiroJsf;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

@ManagedBean
public class ListaDeContatos {
	private ListDataModel<Contato> listModel;
	
	public ListDataModel<Contato> getContatos() {
		listModel =  new ListDataModel<Contato>(Dao.getInstance().getLista());
		return listModel;
	}
	
	public boolean isTemContatos() {
		return Dao.getInstance().getQuantidade() > 0;
	}
	
	@SuppressWarnings("unchecked")
	public boolean isEditando() {
		boolean editando = false;
		for (Contato obj : (List<Contato>)listModel.getWrappedData()) {
			if(obj.isEmEdicao()) {
				editando = true;
				break;
			}
		}
		return editando;
	}
	
	@SuppressWarnings("unchecked")
	public void excluirSelecionados() {
		Dao dao = Dao.getInstance();
		
		List<Contato> model =  (List<Contato>) listModel.getWrappedData();
		for (Contato obj : model) {
			if(obj.isDel()) {
				dao.excluir(obj.getId());
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void salvarAlterados() {
		Dao dao = Dao.getInstance();
		
		List<Contato> model =  (List<Contato>) listModel.getWrappedData();
		for (Contato obj : model) {
			if(obj.isEmEdicao()) {
				dao.salvar(obj);
				obj.setEmEdicao(false);
			}
		}
	}
}
