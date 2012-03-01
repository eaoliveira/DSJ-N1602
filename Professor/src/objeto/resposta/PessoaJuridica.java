package objeto.resposta;

public class PessoaJuridica extends Pessoa {
	private String cnpj;
	private String incrEst;
	private String site;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getIncrEst() {
		return incrEst;
	}

	public void setIncrEst(String incrEst) {
		this.incrEst = incrEst;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return super.toString() + " cnpj:" + cnpj + " incrEst:" + incrEst
				+ " site:" + site;
	}

}
