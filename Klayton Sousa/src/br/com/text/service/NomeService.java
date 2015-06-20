package br.com.text.service;

import java.util.ArrayList;
import java.util.List;

import xml.Nome;
import xml.Produto;



public class NomeService {
	private static List<Produto> lista = new ArrayList<Produto>();
	private static int id = 0;
	private static NomeService thisClass = null;
	
	private NomeService() {
	}
	
	public static NomeService getInstance() {
		if (thisClass == null)
			thisClass = new NomeService();

		return thisClass;
	}

	public List<Produto> listaTodos() {
		return new ArrayList<Produto>(lista);
	}
	
	public List<Produto> buscar(String produto) {	
		List<Produto> novaLista = new ArrayList<Produto>();
		lista.stream()
			.filter(obj -> obj.getNome().equals(produto))
			.forEach(obj -> novaLista.add(obj));
		
		return novaLista;
	}
	public Produto buscar(int chave) {
		int index = lista.indexOf(new Produto(chave));
		
		if(index >= 0)
			return lista.get(index);
		else 
			return null;
	}
	public Produto salvar(Produto obj) {
		Produto novo = null;

		if (obj.getId() == Nome.NOVO_REGISTRO) {
			novo = new Produto();
			novo.setId(++id);
			novo.setDescricao(obj.getDescricao());
			lista.add(novo);
		} else {
			if (lista.contains(obj)) {
				novo = lista.get(lista.indexOf(obj));
				novo.setId(obj.getId());
				novo.setNome(obj.getNome());
			}
		}
		
		return novo;
	}
	public void remover(int chave) {
		int index =  lista.indexOf(new Produto(chave));
		
		if(index >= 0)
			lista.remove(index);
	}

	public int quantos() {
		return lista.size();
	}

	
	
}
