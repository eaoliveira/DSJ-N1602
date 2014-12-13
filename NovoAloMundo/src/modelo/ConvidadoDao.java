package modelo;

import java.util.ArrayList;
import java.util.*;


public class ConvidadoDao {
	private static ConvidadoDao thisInstance = null;
	
	private List<Convidado> lista;
	int id = 0;
	
	private ConvidadoDao() {
		lista = new  ArrayList<>();
	}
	
	public static ConvidadoDao getInstance() {
		if(thisInstance == null)
			thisInstance = new ConvidadoDao();
		
		return thisInstance;
	}
	
	public void add(Convidado obj) {
		obj.setId(id++);
		lista.add(obj);
	}
	
	public void del(Integer id) {
		Convidado item = null;
		for (Convidado obj : lista) {
			if(obj.getId().equals(id)) {
				item = obj;
				break;
			}
		}
		
		if(item != null)
			lista.remove(item);
	}
	
	public List<Convidado> getLista() {
		return Collections.synchronizedList(lista);
	}
}
