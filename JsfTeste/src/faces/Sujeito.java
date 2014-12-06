package faces;

public class Sujeito {
	private boolean del = false;
	private String nome;
	private int idade;
	
	public Sujeito(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public boolean isDel() {
		return del;
	}
	public void setDel(boolean del) {
		this.del = del;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
