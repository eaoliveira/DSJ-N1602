package banco;

import java.util.Random;

public class Cliente {
private int documentos;
private boolean tipoCliente;
private static Random r = new Random();
	public Cliente(){
		tipoCliente = r.nextBoolean();
		documentos = r.nextInt(10);
		
		
	}

	public int getDocumentos() {
		return documentos;
	}

	public void setDocumentos(int documentos) {
		this.documentos = documentos;
	}

	public boolean isTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(boolean tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public String toString() {
		return "documentos " + documentos + ": tipoCliente " + tipoCliente;
	}
	
	
}
