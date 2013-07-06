package projetoWeb.servico;

import java.util.ArrayList;
import java.util.List;

import projetoWeb.modelo.Produto;

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
		List<Produto> novaLista = new ArrayList<Produto>();
		for (Produto obj : lista) {
			if (obj.getNome().equals(nome))
				novaLista.add(obj);
		}
		return novaLista;
	}

	public Produto buscar(int chave) {
		Produto it = null;
		for (Produto obj : lista) {
			if (obj.getId() == chave) {
				it = obj;
				break;
			}
		}
		return it;
	}

	public Produto salvar(Produto obj) {
			Produto novo = new Produto();
			novo.setId(id++);
			novo.setNome(obj.getNome());
			novo.setDescricao(obj.getDescricao());
			novo.setPreco(obj.getPreco());
			lista.add(novo);
			return novo;
	}

	public boolean atualizar(Produto obj) {
		boolean ret = false;
		for (Produto n : lista) {
			if (n.getId() == obj.getId()) {
				n.setNome(obj.getNome());
				n.setDescricao(obj.getDescricao());
				n.setPreco(obj.getPreco());
				ret = true;
				break;
			}
		}
		return ret;
	}

	public void remover(int chave) {
		Produto it = null;
		for (Produto obj : lista) {
			if (obj.getId() == chave) {
				it = obj;
				break;
			}
		}
		lista.remove(it);
	}

	public int quantos() {
		return lista.size();
	}
}
