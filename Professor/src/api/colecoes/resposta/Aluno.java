package api.colecoes.resposta;

public class Aluno implements Comparable<Aluno> {
	private String nome;
	private String matricula;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "matricula: " + matricula + "  nome: " + nome;
	}

	@Override
	public int compareTo(Aluno o) {
		return nome.compareTo(o.nome);
	}
}
