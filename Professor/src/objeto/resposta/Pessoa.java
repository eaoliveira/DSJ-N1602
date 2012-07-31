package objeto.resposta;

import objeto.respostas.Endereco;

public class Pessoa implements Comparable<Pessoa>{
	private String nome;
	private Endereco endereco;
	private String fone;

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
		return "nome:" + nome + " endereco:" + endereco + " fone:" + fone;
	}

	@Override
	public int compareTo(Pessoa o) {
		return nome.compareTo(o.nome);
	}

}
