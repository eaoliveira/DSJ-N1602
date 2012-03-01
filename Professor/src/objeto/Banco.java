package objeto;

public class Banco {
	private String tipo;
	private String marca;
	private boolean ajusteDeAltura;
	private boolean aquecimento;
	private boolean encostoCabeca;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean isAjusteDeAltura() {
		return ajusteDeAltura;
	}

	public void setAjusteDeAltura(boolean ajusteDeAltura) {
		this.ajusteDeAltura = ajusteDeAltura;
	}

	public boolean isAquecimento() {
		return aquecimento;
	}

	public void setAquecimento(boolean aquecimento) {
		this.aquecimento = aquecimento;
	}

	public boolean isEncostoCabeca() {
		return encostoCabeca;
	}

	public void setEncostoCabeca(boolean encostoCabeca) {
		this.encostoCabeca = encostoCabeca;
	}

	@Override
	public String toString() {
		return "Tipo:" + tipo + 
				" Marca:" + marca + 
				" Ajuste de Altura:"	+ (ajusteDeAltura ? "Sim" : "Não") + 
				" Aquecimento:" + (aquecimento ? "Sim" : "Não") + 
				" Encosto Cabeca:"	+ (encostoCabeca ? "Sim" : "Não");
	}

}
