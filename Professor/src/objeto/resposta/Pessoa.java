package objeto.resposta;

public class Pessoa implements Comparable<Pessoa>{
	private String nome;
	private Endereco endereco;
	private String fone;
	
	public Pessoa() {
		super();
	}

	public Pessoa(String nome, Endereco endereco, String fone) {
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
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

	@Override
	public int compareTo(Pessoa o) {
//		int este = this instanceof PessoaFisica ? 1 : 2;
//		int outro = o instanceof PessoaFisica ? 1 : 2;
//		int r = este - outro;
//		if(r == 0)
			int r = nome.compareTo(o.nome);
		
		return r;
	}
	
}
