package br.senai.sp.caseiros.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.senai.sp.caseiros.modelo.Produto;

public class GerenteDeDados {
	private static GerenteDeDados thisInstance;
	private List<Produto> lista; 
	private int id = 0; 
	
	private GerenteDeDados() {
		lista = new ArrayList<>();
	}
	
	public static GerenteDeDados getInstance() {
		if(thisInstance == null)
			thisInstance = new GerenteDeDados();
		
		return thisInstance;
	}

	public void salvar(Produto obj) {
		if(obj.getId() == null) {
			obj.setId(id++);
			lista.add(obj);
		} else {
			lista.set(lista.indexOf(obj), obj);
		}
	}
	
	public List<Produto> getLista() {
		return Collections.synchronizedList(new ArrayList<>(lista));
	}
	
	public void remover(Produto obj) {
		lista.remove(lista.indexOf(obj));
	}
	
	public void remover(String[] ids) {
		for (String txt : ids) {
			int id = Integer.parseInt(txt);
			lista.remove(new Produto(id));
		}
	}
	
	public void remover(Integer id) {
		lista.remove(new Produto(id));
	}
	
	public Produto localiza(Integer id) {
		return lista.get(lista.indexOf(new Produto(id)));
	}
	
	public List<Produto> localiza(String nome) {
		// utilizado somente para retornar o indice de um objeto com o
		// nome igual ao informado
		//Collections.binarySearch(lista, new Produto(nome));
		
		List<Produto> encontrados = new ArrayList<>();
		for (int i = 0; i < lista.size(); i++) {
			Produto obj = lista.get(i);
//		for (Produto obj : lista) {
			if(obj.getNome().matches(".*"+nome+".*"))
				encontrados.add(obj);
		}
		
		return encontrados;
	}
}
