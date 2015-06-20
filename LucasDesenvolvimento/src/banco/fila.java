package banco;

import java.util.ArrayDeque;
import java.util.Queue;

public class fila {

	private Queue<cliente> fila  = new ArrayDeque<>();
	
	public synchronized void entrar(cliente obj){
		fila.add(obj);
	}
	
	public synchronized cliente proximo(){
		return fila.poll();
	}
	public synchronized boolean temGente(){
		return fila.isEmpty();
	}
	public synchronized int quantos(){
		return fila.size();
	}
	
}
