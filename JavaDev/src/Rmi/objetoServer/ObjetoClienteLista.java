package Rmi.objetoServer;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ObjetoClienteLista {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		System.setSecurityManager(new SecurityManager());

		ObjetoInterface rem = (ObjetoInterface) Naming.lookup("rmi://10.84.144.250/telaSwing");
		
		List<Registro> objList = new ArrayList<>(); 
		objList.add(new Registro("Fulano de Tal", 35, "fufu@gmail.com"));
		objList.add(new Registro("Beltrano da Silva", 25, "beltrano@hotmail.com"));
		objList.add(new Registro("Ciclano de Souza", 45, "ciclano@bol.com"));
		objList.add(new Registro("Xiquinha da Silva", 35, "xica@gmail.com"));
		
		rem.salvaLista(objList);
	}
}


class Registro implements Serializable {
	private static final long serialVersionUID = 1464448524025782101L;

	private String nome;
	private int idade;
	private String email;

	public Registro() {
		super();
	}

	public Registro(String nome, int idade, String email) {
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