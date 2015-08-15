package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Nomes;


public class Dao {
	private static Dao thisInstance;
	private List<Nomes> lista;
	private int id = 0;
	
	private Dao() {
		lista = new ArrayList<>();
	}
	
	public static Dao getInstance() {
		if(thisInstance == null) {
			thisInstance = new Dao();
		}
		return thisInstance;
	}
	
	public void salva(String txt) {
		lista.add(new Nomes(id++, txt));
	}
	
	public int quantos() {
		return lista.size();
	}
	
	public List<Nomes> getLista() {
		return Collections.synchronizedList(lista);
	}
	
	public void apaga(List<Nomes> obj) {
		lista.removeAll(obj);
	}
}
