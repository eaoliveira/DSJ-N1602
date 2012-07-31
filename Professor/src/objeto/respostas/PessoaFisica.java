package objeto.respostas;


public class PessoaFisica extends Pessoa {
	private String rg;
	private String cpf;
	private String email;

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return super.toString() + " rg:" + rg + " cpf:" + cpf + " email:" + email;
	}

}
