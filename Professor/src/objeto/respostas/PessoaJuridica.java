package objeto.respostas;


public class PessoaJuridica extends Pessoa {
	private String cnpj;
	private String inscrEst;
	private String site;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscrEst() {
		return inscrEst;
	}

	public void setInscrEst(String inscrEst) {
		this.inscrEst = inscrEst;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return super.toString()  + " cnpj:" + cnpj + " inscrEst:" + inscrEst + " site:" + site;
	}

}
