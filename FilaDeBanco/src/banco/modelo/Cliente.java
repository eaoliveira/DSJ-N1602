package banco.modelo;

import java.util.Random;

public class Cliente {
	private Integer documentos;
	private TipoCliente tipo;
	private static Random mix = new Random();
	
	public Cliente() {
		// Determina aleatoriamente o Tipo do Cliente
		if(mix.nextBoolean())
			tipo = TipoCliente.NORMAL;
		else
			tipo = TipoCliente.IDOSO;
		
		// gera um nº aleatorio de documentos entre 1 e 5
		this.documentos = (int)Math.ceil(Math.random() * 5);
	}
	
	public TipoCliente getTipoCliente() {
		return tipo;
	}
	
	public Integer getDocumentos() {
		return documentos;
	}
}
