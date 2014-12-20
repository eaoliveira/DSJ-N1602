package view;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;

import model.EntityDao;
import model.Turma;
import bean.TurmaItem;

@ManagedBean(name="turmas")
@RequestScoped
public class ListaTurma {
	@EJB
	private EntityDao dao;
	private ListDataModel<TurmaItem> dados = null;

	public int getCount() {
		return dao.getTurmas().size();
	}

	public ListDataModel<TurmaItem> getLista() {
		List<Turma> lista = dao.getTurmas();
		List<TurmaItem> novalista = new ArrayList<TurmaItem>();

		for (int i = 0; i < lista.size(); i++) {
			Turma turma = lista.get(i);
			novalista.add(new TurmaItem(
					turma.getId(),
					turma.getTitulo(),
					turma.getInicio(),
					turma.getNumhoras()));
		}

		dados = new ListDataModel<TurmaItem>(novalista);
		return dados;
	}

	@SuppressWarnings("unchecked")
	public String apagar() {
		    for(TurmaItem s : (List<TurmaItem>)dados.getWrappedData()) {
		        if(s.isDel())
		        	dao.remove(s.getId());
		    }
		    
			return "";
		}
}
