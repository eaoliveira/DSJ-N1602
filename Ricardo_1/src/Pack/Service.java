package Pack;

import java.util.ArrayList;
import java.util.List;

import Pack.Bean;

public class Service {
	private static List<Nome> lista = new ArrayList<Nome>();
	private static int id = 0;
	private static Service thisClass = null;

	private Service() {
	}

	public static Service getInstance() {
		if (thisClass == null)
			thisClass = new Service();

		return thisClass;
	}

	public List<Nome> listaTodos() {
		return new ArrayList<Nome>(lista);
	}
	
	public List<Nome> buscar(String nome) {	
		List<Nome> novaLista = new ArrayList<Nome>();
		lista.stream()
			.filter(obj -> obj.getNome().equals(nome))
			.forEach(obj -> novaLista.add(obj));
		
//		
//		for (Nome obj : lista) {
//			if (obj.getPrimeiroNome().equals(nome))
//				novaLista.add(obj);
//		}
		return novaLista;
	}

	public Nome buscar(int chave) {
		int index = lista.indexOf(new Nome(chave));
		
		if(index >= 0)
			return lista.get(index);
		else 
			return null;
	}

	public Nome salvar(Nome obj) {
		Nome novo = null;

		if (obj.getId() == Nome.NOVO_REGISTRO) {
			novo = new Nome();
			novo.setId(++id);
			novo.setDescricao(obj.getDescricao());
			novo.setPreco(obj.getPreco());
			novo.setNome(obj.getNome());
			lista.add(novo);
		} else {
			if (lista.contains(obj)) {
				novo = lista.get(lista.indexOf(obj));
				novo.setDescricao(obj.getDescricao());
				novo.setPreco(obj.getPreco());
			}
		}
		
		return novo;
	}

	public void remover(int chave) {
		int index =  lista.indexOf(new Nome(chave));
		
		if(index >= 0)
			lista.remove(index);
	}

	public int quantos() {
		return lista.size();
	}
}
