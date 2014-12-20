package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

import model.Nomes;
import dados.Dao;

@ManagedBean
public class ListaCadastro {
	private Dao dao = Dao.getInstance();
	private ListDataModel<NomeModel> model;

	public int quantidade() {
		return dao.quantos();
	}

	public ListDataModel<NomeModel> getNomes() {
		List<NomeModel> lista = new ArrayList<>();
		for (Nomes obj : dao.getLista()) {
			lista.add(new NomeModel(obj));
		}
		model = new ListDataModel<NomeModel>(lista);
		return model;
	}

	public void setNomes(ListDataModel<NomeModel> lista) {
		this.model = lista;
		for (NomeModel nome : lista) {
			System.out.println(nome.getNome() + " " + nome.isDel());
		}
	}

	public void apaga() {
		List<Nomes> lista = new ArrayList<>();
		for (NomeModel obj : model) {
			System.out.println(obj.getNome() + " " + obj.isDel());
			if (obj.isDel())
				lista.add(new Nomes(obj.getId()));
		}
		dao.apaga(lista);
	}
}
