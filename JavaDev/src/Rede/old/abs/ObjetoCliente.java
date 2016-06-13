package Rede.old.abs;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ObjetoCliente {
	public static void main(String[] args) {
		try {
			List<Contato> lista = new ArrayList<Contato>();
			lista.add(new Contato("Fulano","fulano@gmail.com"));
			lista.add(new Contato("Beltrano","beltrano@hotmail.com"));
			lista.add(new Contato("Ciclano","ciclano@gol.com"));
			
			Socket skt = new Socket("10.84.144.250", 1234);
			ObjectOutputStream out = new ObjectOutputStream(skt.getOutputStream());
			out.writeObject(lista);
			out.flush();
			skt.close();
		} catch (Exception ex) {
			//ex.printStackTrace();
			System.err.println("Erro durante a transmissão dos dados");
		}
	}
}
