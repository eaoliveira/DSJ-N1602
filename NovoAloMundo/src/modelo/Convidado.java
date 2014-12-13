package modelo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Convidado {
	private Integer id;
	
	@Size(max=45, min=4, message="O Nome deve ter no mínimo 4 e no máximo 45 caracters")
	private String nome;
	@Pattern(regexp="(\\w{3,}\\.)*\\w{3,}@(\\w{3,}\\.){1,}\\w{2,}", message="E-mail inválido")
	private String email;
	@Min(value=16, message="A idade mínima é 16 anos")
	@Max(value=60, message="A idade máxima é 60 anos")
	private int idade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Convidado [nome=" + nome + ", email=" + email + ", idade="
				+ idade + "]";
	}
}
