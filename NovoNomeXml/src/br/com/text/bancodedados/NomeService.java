package br.com.text.bancodedados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.text.xml.Nome;

public class NomeService {
	private static List<Nome> lista = new ArrayList<Nome>();
	private static int id = 0;
	private static NomeService thisClass = null;

	private NomeService() {
	}

	public static NomeService getInstance() {
		if (thisClass == null)
			thisClass = new NomeService();

		return thisClass;
	}

	public List<Nome> listaTodos() {
		return Collections.unmodifiableList(lista);
	}
	
	public List<Nome> lista(long timestamp) {
		return lista.stream()
				.filter(obj -> obj.getTimestamp() > timestamp)
				.collect(Collectors.toList());		
	}

	public List<Nome> buscar(String nome) {	
		return lista.stream()
				.filter(obj -> obj.getPrimeiroNome().equals(nome))
				.collect(Collectors.toList());
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
			// retorna um objeto válido com o ID atribuido
			novo = obj;
			novo.setId(++id);
			lista.add(novo);
		} else {
			if (lista.contains(obj)) {
				novo = lista.get(lista.indexOf(obj));
				
				if(obj.getTimestamp() == 0 || obj.getTimestamp() > novo.getTimestamp()) {
					novo.setIdade(obj.getIdade());
					novo.setPrimeiroNome(obj.getPrimeiroNome());
					novo.setTimestamp(new Date().getTime());
				}
			}
		}
		
		return novo;
	}

	public void remover(int chave, long data) {
		int index =  lista.indexOf(new Nome(chave));
		
		if(index >= 0) {
			Nome obj = lista.get(index);
			
			if(data > obj.getTimestamp())
				lista.remove(index);
		}
	}

	public void remover(int chave) {
//		int index =  lista.indexOf(new Nome(chave));
//		
//		if(index >= 0)
//			lista.remove(index);
		
		lista.removeIf(reg -> reg.getId() == chave);
	}

	public int quantos() {
		return lista.size();
	}
}
