package banco.model;

import java.util.Random;

public class Cliente {
	private static Random rd = new Random();
	private int documentos = rd.nextInt(10);  // ajuste do nº máximo de documentos de um cliente
	private TipoCliente tipo = rd.nextBoolean() ? TipoCliente.IDOSO : TipoCliente.NORMAL;

	public int getDocumentos() {
		return documentos;
	}

	public void setDocumentos(int documentos) {
		this.documentos = documentos;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}

}
