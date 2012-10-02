package banco.modelo;

import java.util.ArrayDeque;
import java.util.Queue;

public class FilaBancaria {
	private Queue<Cliente> fila = new ArrayDeque<Cliente>();
	
	public synchronized void entre(Cliente c) {
		fila.add(c);
	}
	
	public synchronized Integer quantidade() {
		return fila.size();
	}
	
	public synchronized Cliente proximo() {
		return fila.poll();
	}
	
	public synchronized Boolean estaVazia() {
		return fila.isEmpty();
	}
}
