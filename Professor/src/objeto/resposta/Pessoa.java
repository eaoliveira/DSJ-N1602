package objeto.resposta;

public class Pessoa {
	private String nome;
	private String endereco;
	private String fone;
	
	public Pessoa() {
		super();
	}

	public Pessoa(String nome, String endereco, String fone) {
		this.nome = nome;
		this.endereco = endereco;
		this.fone = fone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	@Override
	public String toString() {
		return "Nome:" + nome + " End.:" + endereco + " Fone:" + fone;
	}
	
}
