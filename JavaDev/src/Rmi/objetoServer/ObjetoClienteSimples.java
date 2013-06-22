package Rmi.objetoServer;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class ObjetoClienteSimples {
	public static void main(String[] args) throws MalformedURLException,
			RemoteException, NotBoundException {
		System.setSecurityManager(new RMISecurityManager());

		ObjetoInterface rem = (ObjetoInterface) Naming
				.lookup("rmi://10.190.39.250/telaSwing");
		
		Teste obj = new Teste("Fulano de Tal", 35, "fufu@gmail.com");
		
		rem.salva(obj);
	}
}


class Teste implements Serializable {
	private static final long serialVersionUID = 1364448524025782101L;
	
	private String nome;
	private int idade;
	private String email;

	public Teste() {
		super();
	}

	public Teste(String nome, int idade, String email) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "nome:  " + nome + "  idade:  " + idade + "  email:  " + email;
	}

}