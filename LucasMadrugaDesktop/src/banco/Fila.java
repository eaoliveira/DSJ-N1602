package banco;

import java.util.ArrayDeque;
import java.util.Queue;

public class Fila {
	private Queue<Cliente> fila = new ArrayDeque<Cliente>();

	public synchronized void entrar(Cliente c){
		fila.add(c);	
	}
	
	public synchronized Cliente proximo(){		
		return fila.poll();
	}
	
	public synchronized boolean temGente(){
		return fila.isEmpty();
	}
	
	public synchronized int quantos(){
		return fila.size();
	}

}
