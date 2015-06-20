package br.com.text.service;

import java.util.ArrayList;
import java.util.List;

import br.com.text.Xml.produtos;

public class Servico {

	private static List<produtos> lista = new ArrayList<produtos>();
	private static int id = 0;
	private static String produto = "";
	private static String descricao = "";
	private static float preco = 0;
	private static Servico thisClass = null;
	
	private Servico(){
    }
 //Cria uma nova intancia na execução do serviço
	public static Servico getInstance() {
		if (thisClass == null)
			thisClass = new Servico();
		return thisClass;
	}
//Listar o Array de Produtos 
	public List<produtos> listarProdutos(){
		return new ArrayList<produtos>(lista);
	}
	
//Conteudo de Busca
/*
 	public List<produtos> buscar(String nome) {
		List novaLista = new ArrayList<produtos>;
		lista.stream()
			.filter(obj -> obj.getProduto()().equals(nome))
			.forEach(obj -> novaLista.add(obj));
		

		return novaLista;
	}
	*/	
	
//Metodo Salvar
	

	public produtos salvar(produtos obj) {
		produtos novo = null;

		if (obj.getId() == produtos.NOVO_REGISTRO) {
			novo = new produtos();
			novo.setId(++id);
			novo.setProduto(obj.getProduto());
			novo.setDescricao(obj.getDescricao());
			novo.setPreco(obj.getPreco());
			
			lista.add(novo);
		} else {
			if (lista.contains(obj)) {
				novo = lista.get(lista.indexOf(obj));
				novo.setProduto(obj.getProduto());
				novo.setDescricao(obj.getDescricao());
				novo.setPreco(obj.getPreco());
			}
		}
		
		return novo;
	}
	


}
