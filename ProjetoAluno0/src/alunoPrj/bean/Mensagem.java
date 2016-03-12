package alunoPrj.bean;

public class Mensagem {
	private String texto;
	private String pag;

	public Mensagem() {
		pag = null;
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getPag() {
		return pag;
	}

	public void setPag(String pag) {
		this.pag = pag;
	}

}
