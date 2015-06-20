package Thread.FilaBancaria;

import java.util.ArrayDeque;
import java.util.Queue;



public class FilaBancaria {
	
	Queue<Cliente> fila = new ArrayDeque<>();
	
	synchronized public void entrar(Cliente c){
		
		fila.add(c);
	}
	synchronized Cliente proximo(){
		return  fila.poll();
	}	
	
	synchronized boolean temGente(){
		return fila.isEmpty();
		
	}
	synchronized int quantos(){
		return fila.size();
	}

}
