package caddata.bean;

public class Mensagem {
	private String texto = "";
	private String url = "";

	public Mensagem(String texto, String url) {
		super();
		this.texto = texto;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}
