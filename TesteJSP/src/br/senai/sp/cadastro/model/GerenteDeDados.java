package br.senai.sp.cadastro.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Pattern - Singleton
public class GerenteDeDados {
	private List<Cliente> lista;
	private static GerenteDeDados meuGerente;
	int id = 0;
	
	private GerenteDeDados() {
		lista = new ArrayList<>();
	}
	
	public static GerenteDeDados getInstance() {
		if(meuGerente == null)
		   meuGerente = new GerenteDeDados();
		
		return meuGerente;
	}
	
	public void salvar(Cliente obj) {
		Cliente clienteEntrado = null;
		for (Cliente reg : lista) {
			if(reg.getNome().equals(obj.getNome())) {
				clienteEntrado = reg;
				break;
			}
		}
		if(clienteEntrado == null) {
			obj.setId(id++);
			lista.add(obj);
		} else {
			clienteEntrado.setEmail(obj.getEmail());
			clienteEntrado.setFone(obj.getFone());
			clienteEntrado.setEndereco(obj.getEndereco());
		}
	}
	
	public void remover(int id) {
		int indice = lista.indexOf(new Cliente(id));
		lista.remove(indice);
	}

	public List<Cliente> getClientes() {
		return Collections.synchronizedList(new ArrayList<>(lista));
	}
}
