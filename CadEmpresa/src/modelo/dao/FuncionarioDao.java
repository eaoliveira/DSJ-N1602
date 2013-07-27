package modelo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelo.Funcionario;

public class FuncionarioDao {
	private static FuncionarioDao instancia = null;
	private List<Funcionario> lista;
	private int id = 0;

	private FuncionarioDao() {
		lista = new ArrayList<Funcionario>();
	}

	public static FuncionarioDao getInstance() {
		if (instancia == null)
			instancia = new FuncionarioDao();

		return instancia;
	}

	public void salvar(Funcionario obj) {
		if (obj.getId() == null) {
			obj.setId(id++);
			lista.add(obj);
		} else {
			lista.set(lista.indexOf(obj), obj);
		}
	}

	public void remover(int id) {
		lista.remove(new Funcionario(id));
	}
	
	public List<Funcionario> getDados() {
		return Collections.synchronizedList(lista);
	}
	
	public int quantos() {
		return lista.size();
	}
}
