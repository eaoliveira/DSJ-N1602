package api.colecoes.resposta;

public class Fone {
	private String ddd;
	private String numero;
	private TipoFone tipo;

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoFone getTipo() {
		return tipo;
	}

	public void setTipo(TipoFone tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "ddd:" + ddd + " numero:" + numero + " tipo:" + tipo;
	}

}
