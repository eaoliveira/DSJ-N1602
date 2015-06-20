package br.com.text.service;

import java.util.ArrayList;
import java.util.List;

public class NomeService {
	private static List<Produto> lista = new ArrayList<Produto>();
	private static int id = 0;
	private static NomeService thisClass = null;

	public NomeService() {
		Produto prod = new Produto();
		prod.setId(1);
		prod.setNome("teste");
		lista.add(prod);
	}

	static NomeService getInstance() {
		if (thisClass == null) {
			thisClass = new NomeService();
		}
		return thisClass;
	}

	public List<Produto> listaTodos() {
		return new ArrayList<Produto>(lista);
	}

	public List<Produto> buscar(String produto) {

		List<Produto> novaLista = new ArrayList<Produto>();
		lista.stream().filter(obj -> obj.getNome().equals(produto))
				.forEach(obj -> novaLista.add(obj));

		//
		// for (Nome obj : lista) {
		// if (obj.getPrimeiroNome().equals(nome))
		// novaLista.add(obj);
		// }
		return novaLista;
	}

	public Produto buscar(int chave) {
		int index = lista.indexOf(new Produto(chave));
		if (index >= 0) {
			return lista.get(index);
		} else {
			return null;
		}

	}

	public Produto salvar(Produto obj) {
		Produto novo = null;
		System.out.println("1 nome " + obj.nome);
		System.out.println("1 nome " + obj.id);
		if (obj.getId() == (Produto.NOVO_REGISTRO)) {
			novo = new Produto();
			int novoId = (++id);
			novo.setId(novoId);
			System.out.println("1 nome " + obj.nome);
			System.out.println("1 nome " + obj.id);
			//novo.setDescricao(obj.getDescricao());
			//novo.setPreco(obj.getPreco());
			lista.add(novo);
		} else {
			if (lista.contains(obj)) {
				System.out.println("criando um novo");
				novo = lista.get(lista.indexOf(obj));
				novo.setId(obj.getId());
				novo.setNome(obj.getNome());
			}
		}
		System.out.println("2 nome" + novo.nome);
		return novo;
	}

	public void remover(int chave) {
		int index = lista.indexOf(new Produto(chave));

		if (index >= 0)
			lista.remove(index);
	}
	public int quantos() {
		return lista.size();
	}
}
