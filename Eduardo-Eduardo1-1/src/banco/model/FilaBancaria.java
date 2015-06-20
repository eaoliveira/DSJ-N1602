package banco.model;

import java.util.ArrayDeque;
import java.util.Queue;

public class FilaBancaria {
	private Queue<Cliente> fila = new ArrayDeque<>();
	
	public void entra(Cliente obj) {
		fila.add(obj);
	}
	
	public Cliente proximo() {
		return fila.poll();
	}
	
	public int quantos() {
		return fila.size();
	}
}
