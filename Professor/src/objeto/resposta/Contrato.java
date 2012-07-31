package objeto.resposta;

public class Contrato {
	private int numero;
	private int ano;
	private String descricao;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Numero:" + numero + " Ano:" + ano + " Descr.:" + descricao;
	}

}
