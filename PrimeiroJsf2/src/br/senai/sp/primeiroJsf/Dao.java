package br.senai.sp.primeiroJsf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dao {
	private List<Contato> lista;
	private int id = 0;
	private static Dao instance;

	private Dao() {
		lista = new ArrayList<Contato>();
	}
	
	public static Dao getInstance() {
		if(instance == null)
			instance = new Dao();
		return instance;
	}
	
	public void salvar(Contato obj) {
		if(obj.getId() == null) {
			obj.setId(++id);
			lista.add(obj);
		} else {
			for (Contato con : lista) {
				if(con.getId().equals(obj.getId())) {
					con.setNome(obj.getNome());
					con.setEmail(obj.getEmail());
					con.setTelefone(obj.getTelefone());
				}
			}
		}
	}
	
	public Contato getContato(Integer id) {
		for (Contato con : lista) {
			if(con.getId().equals(id)) {
				return con;
			}
		}
		return null;
	}
 	
	public List<Contato> getLista() {
		return Collections.synchronizedList(new ArrayList<>(lista));
	}
	
	public int getQuantidade() {
		return lista.size();
	}

	public void excluir(Integer id) {
		for (Contato obj : lista) {
			if(obj.getId().equals(id)) {
				lista.remove(obj);
				break;
			}
		}
	}
}

