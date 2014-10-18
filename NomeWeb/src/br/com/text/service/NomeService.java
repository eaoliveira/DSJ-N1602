package br.com.text.service;

import java.util.ArrayList;
import java.util.List;

import xml.Nome;

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
		return new ArrayList<Nome>(lista);
	}

	public List<Nome> buscar(String nome) {
		List<Nome> novaLista = new ArrayList<Nome>();
		for (Nome obj : lista) {
			if (obj.getPrimeiroNome().equals(nome))
				novaLista.add(obj);
		}
		return novaLista;
	}

	public Nome buscar(int chave) {
		Nome it = null;
		for (Nome obj : lista) {
			if (obj.getId() == chave) {
				it = obj;
				break;
			}
		}
		return it;
	}

	public Nome salvar(Nome obj) {
			Nome novo = new Nome();
			novo.setId(id++);
			novo.setIdade(obj.getIdade());
			novo.setPrimeiroNome(obj.getPrimeiroNome());
			lista.add(novo);
			return novo;
	}

	public boolean atualizar(Nome obj) {
		boolean ret = false;
		for (Nome n : lista) {
			if (n.getId() == obj.getId()) {
				n.setIdade(obj.getIdade());
				n.setPrimeiroNome(obj.getPrimeiroNome());
				ret = true;
				break;
			}
		}
		return ret;
	}

	public void remover(int chave) {
		Nome it = null;
		for (Nome obj : lista) {
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
