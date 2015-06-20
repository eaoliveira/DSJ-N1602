package br.com.text.service;

import java.util.ArrayList;
import java.util.List;

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

//	public List<Produto> listaTodos() {
//		return new ArrayList<Produto>(lista);
//	}
//	
//	public List<Produto> buscar(String Produto) {	
//		List<Produto> novaLista = new ArrayList<Produto>();
//		lista.stream()
//			.filter(obj -> obj.getPrimeiroProduto().equals(Produto))
//			.forEach(obj -> novaLista.add(obj));
//		
////		
////		for (Produto obj : lista) {
////			if (obj.getPrimeiroProduto().equals(Produto))
////				novaLista.add(obj);
////		}
//		return novaLista;
//	}

//	public Produto buscar(int chave) {
//		int index = lista.indexOf(new Produto(chave));
//		
//		if(index >= 0)
//			return lista.get(index);
//		else 
//			return null;
//	}

	public Produto salvar(Produto obj) {
		Produto novo = null;

		if (obj.getId() == Produto.NOVO_REGISTRO) {
			novo = new Produto(null);
			novo.setId(++id);
			novo.setNome(obj.getNome());
			novo.setDescricao(obj.getDescricao());
			novo.setPreco(obj.getPreco());
			lista.add(novo);
		} else {
			if (lista.contains(obj)) {
				novo = lista.get(lista.indexOf(obj));
				novo.setNome(obj.getNome());
				novo.setDescricao(obj.getDescricao());
				novo.setPreco(obj.getPreco());
			}
		}
		
		return novo;
	}

	public void remover(String chave) {
		int index =  lista.indexOf(new Produto(chave));
		
		if(index >= 0)
			lista.remove(index);
	}

	public int quantos() {
		return lista.size();
	}
}
