package Rede.cliente;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClienteObjeto {
	public static void main(String[] args) {
		try {
			List<Contato> lista = new ArrayList<Contato>();
			lista.add(new Contato("Fulano","fulano@gmail.com"));
			lista.add(new Contato("Beltrano","beltrano@hotmail.com"));
			lista.add(new Contato("Ciclano","ciclano@gol.com"));
			
			Socket skt = new Socket("localhost", 1235);
			ObjectOutputStream out = new ObjectOutputStream(skt.getOutputStream());
			out.writeObject(lista);
			out.flush();
			skt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}


class Contato implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private String email;

	public Contato() {
		super();
	}

	public Contato(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
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

	@Override
	public String toString() {
		return "Nome: " + nome + " Email: " + email;
	}

}