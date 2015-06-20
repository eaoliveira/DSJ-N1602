package banco;

import java.util.ArrayDeque;
import java.util.Queue;

public class FilaBancaria {
	private Queue<Clientes> fila = new ArrayDeque<>();
	
	public synchronized void entrar(Clientes c) {
		fila.add(c);
	}
	
	public synchronized Clientes proximo() { 
		return fila.poll();
	}
	
	public synchronized boolean temGente() {
		return fila.isEmpty();
	}
	
	public synchronized int quantos() {
		return fila.size();
	}
	

}
