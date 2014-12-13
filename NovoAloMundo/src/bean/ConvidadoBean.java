package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

import modelo.Convidado;
import modelo.ConvidadoDao;

@ManagedBean(name = "convidado")
public class ConvidadoBean {
	private ListDataModel<ConvidadoModel> lista;
	private ConvidadoDao dao = ConvidadoDao.getInstance();
	private Convidado obj = new Convidado();

	// Metodos para inclusao de registros
	public Convidado getObj() {
		return obj;
	}

	public void setObj(Convidado convidado) {
		this.obj = convidado;
	}

	public String salvar() {
		dao.add(obj);
		obj = new Convidado();
		return "";
	}

	// Metodos para gerenciar a lista de registros
	public ListDataModel<ConvidadoModel> getLista() {
		List<ConvidadoModel> itens = new ArrayList<>();
		
		for (Convidado obj : dao.getLista()) {
			itens.add(new ConvidadoModel(obj));
		}
 		lista =  new ListDataModel<ConvidadoModel>(itens);
 		return lista;
	}

	public void setLista(ListDataModel<ConvidadoModel> lista) {
		this.lista = lista;
	}
	
	@SuppressWarnings("unchecked")
	public String remove() {
		for (ConvidadoModel model : (List<ConvidadoModel>)lista.getWrappedData()) {
			if(model.isDel())
				dao.del(model.getId());
		}
		
		return "";
	}
}
