package Modelo;

import java.util.ArrayDeque;
import java.util.Queue;

public class Fila {
	Queue<Cliente> fila;
	
	public Fila() {
		fila = new ArrayDeque<Cliente>();
	}
	
	synchronized public void entrar(Cliente c){
		this.fila.add(c);
	}
	

	synchronized public Cliente proximo() {
		return this.fila.poll();

	}
	
	synchronized public int aFilaEstaVazia() {
		return this.fila.size();

	}
	
	synchronized public boolean temGente(){
		return this.fila.isEmpty();
	}
	
	synchronized public int quantos(){
		return this.fila.size();
	}
}
