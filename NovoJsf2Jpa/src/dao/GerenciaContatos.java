package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelo.Contato;
import modelo.Fone;

public class GerenciaContatos {
	private static GerenciaContatos instancia = null;
	private static int id = 0;
	private static int idFone = 0;

	private List<Contato> lista = null;

	private GerenciaContatos() {
		lista = new ArrayList<Contato>();
	}

	public static GerenciaContatos getInstance() {
		if (instancia == null)
			instancia = new GerenciaContatos();

		return instancia;
	}

	public void salvar(Contato obj) {
		if (obj.getId() == null) { // inclui
			obj.setId(id++);
			lista.add(obj);
		} else { // atualiza
			int indice = lista.indexOf(obj);
			lista.set(indice, obj);
		}
	}

	public void salvar(Fone obj) {
		if (obj.getId() == null) { // inclui
			obj.setId(idFone++);
		}
	}

	public int size() {
		return lista.size();
	}

	public List<Contato> getContatos() {
		return Collections.synchronizedList(lista);
	}

	public void remove(int id) {
		int indice = lista.indexOf(new Contato(id));
		lista.remove(indice);
	}

	public void remove(int contato, int id) {
		int indice = lista.indexOf(new Contato(contato));
		if (indice > -1) {
			Contato obj = lista.get(indice);

			List<Fone> listaFone = obj.getFones();
			int indiceFone = listaFone.indexOf(new Fone(id));
			if (indiceFone > -1) {
				listaFone.remove(indiceFone);
			}
		}
	}

	public Contato localize(int id) {
		int indice = lista.indexOf(new Contato(id));
		return lista.get(indice);
	}
}
