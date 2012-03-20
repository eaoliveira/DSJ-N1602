package api.jdbc.resposta;

public class Contrato {
	private Integer idContrato;
	private String numero;
	private String descricao;

	public Contrato() {
	}
	
	public Contrato(String numero, String descricao) {
		this.numero = numero;
		this.descricao = descricao;
	}

	public Contrato(Integer idContrato, String numero, String descricao) {
		this.idContrato = idContrato;
		this.numero = numero;
		this.descricao = descricao;
	}

	public Integer getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "No.: " + numero + " descricao: "	+ descricao;
	}

}
