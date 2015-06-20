package MeuBanco;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class FilaBancaria {

	private Queue<Cliente> fila = new ArrayDeque<Cliente>();

	public synchronized void entrar(Cliente obj){
		fila.add(obj);
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
