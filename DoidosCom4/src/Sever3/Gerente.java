package Sever3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gerente {
	private static Gerente thisInstance;
	private List<Cursos> lista; 
	private int id = 0; 
	
	private Gerente() {
		lista = new ArrayList<>();
	}
	
	public static Gerente getInstance() {
		if(thisInstance == null)
			thisInstance = new Gerente();
		
		return thisInstance;
	}

	public void salvar(Cursos obj) {
		if(obj.getId() == null) {
			obj.setId(id++);
			lista.add(obj);
		} else {
			lista.set(lista.indexOf(obj), obj);
		}
	}
	
	public List<Cursos> getLista() {
		return Collections.synchronizedList(new ArrayList<>(lista));
	}
	
	public void remover(Cursos obj) {
		lista.remove(lista.indexOf(obj));
	}
	
	public void remover(String[] ids) {
		for (String txt : ids) {
			int id = Integer.parseInt(txt);
			lista.remove(new Cursos(id));
		}
	}
	
	public void remover(Integer id) {
		lista.remove(new Cursos(id));
	}
	
	public Cursos localiza(Integer id) {
		return lista.get(lista.indexOf(new Cursos(id)));
	}
	
	public List<Cursos> localiza(String nome) {
		// utilizado somente para retornar o indice de um objeto com o
		// nome igual ao informado
		//Collections.binarySearch(Cursos, new Cursos(nome));
		
		List<Cursos> encontrados = new ArrayList<>();
		for (int i = 0; i < lista.size(); i++) {
			Cursos obj = lista.get(i);
//		for (Cursos obj : lista) {
			if(obj.getNome().matches(".*"+nome+".*"))
				encontrados.add(obj);
		}
		
		return encontrados;
	}
}