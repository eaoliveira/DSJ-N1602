package doidos.Service;

import java.util.ArrayList;
import java.util.List;

import XML.Produto;

public class ProdutoService {
	private static List<Produto> lista = new ArrayList<Produto>();
	private static int id = 0;
	private static ProdutoService thisClass = null;

	private ProdutoService() {
	}

	public static ProdutoService getInstance() {
		if (thisClass == null)
			thisClass = new ProdutoService();

		return thisClass;
	}

	public List<Produto> listaTodos() {
		return new ArrayList<Produto>(lista);
	}
	
	public List<Produto> buscar(String nome) {	
		List<Produto> novaProduto = new ArrayList<Produto>();
		lista.stream()
			.filter(obj -> obj.getNome().equals(nome))
			.forEach(obj -> novaProduto.add(obj));
		return novaProduto;
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

		if (obj.getId() == Produto.NOVO_REGISTRO) {
			novo = new Produto();
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

	public void remover(int chave) {
		int index =  lista.indexOf(new Produto(chave));
		
		if(index >= 0)
			lista.remove(index);
	}

	public int quantos() {
		return lista.size();
	}
}
