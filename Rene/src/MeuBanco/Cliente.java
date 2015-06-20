package MeuBanco;

import java.util.Random;

public class Cliente {
	
	private int documentos = (int) (Math.random() * 5);
	private boolean tipo;
	private static Random rd = new Random();
	
	public Cliente(){
		
		setTipo(rd.nextBoolean());
		setDocumentos(rd.nextInt(15));
	}

	public int getDocumentos() {
		return documentos;
	}

	public void setDocumentos(int documentos) {
		this.documentos = documentos;
	}

	public boolean getTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	
}
