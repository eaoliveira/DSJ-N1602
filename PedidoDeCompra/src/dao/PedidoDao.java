package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Endereco;
import model.Pedido;

public class PedidoDao {
	private List<Pedido> lista = new ArrayList<>();
	private List<Endereco> listaEnd = new ArrayList<>();
	private static PedidoDao referencia = null;
	private int id = 0;
	private int idEnd = 0;

	private PedidoDao() {
	}

	public static PedidoDao getInstance() {
		if (referencia == null)
			referencia = new PedidoDao();

		return referencia;
	}

	public void adiciona(Pedido obj) {
		obj.setId(id++);
		lista.add(obj);
	}

	public void adiciona(Endereco obj) {
		obj.setId(idEnd++);
		listaEnd.add(obj);
	}
		
	public List<Pedido> getPedidos() {
		return Collections.synchronizedList(new ArrayList<>(lista));
	}
		
	public List<Endereco> getEnderecos() {
		return Collections.synchronizedList(new ArrayList<>(listaEnd));
	}
	
	public Endereco getEndereco(Integer id) {
		Endereco end = null;
		for (Endereco obj : listaEnd) {
			if(obj.getId().equals(id)) {
				end = obj;
				break;
			}
		}
		
		return end;
	}
	
	public boolean delEndereco(int id) {
		return listaEnd.removeIf(end -> end.getId() == id);
	}
	
	public int contadorEnderecos() {
		return listaEnd.size();
	}
}
