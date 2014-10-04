package Rede.abs;

import java.io.*;
import java.net.*;

public class TextoClienteSimples {
	public static void main(String[] args) {
		try (// Cria um Socket e abre uma conexão a um servidor
			 Socket s = new Socket("localhost", 1234);
			 // Cria um Leitor para o Socket
			 BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			 // Cria um Gravador para o Socket
			 PrintWriter out = new PrintWriter(s.getOutputStream());

		 	 // Cria um Leitor para o Teclado
			 BufferedReader cons = new BufferedReader(new InputStreamReader(System.in)); ) {

			// Lê mensagem de boas vindas do Servidor
			System.out.println(in.readLine());

			// Lê os dados do Leitor do Socket
			while (true) {
				String txt = null;
				while(cons.ready()) {
					// Lê o teclado
					txt = cons.readLine();
					// Grava um texto no Gravador do Socket
					out.println(txt);
					out.flush();
				}
				while(in.ready()) {
					// Lê o texto do Servidor
					txt = in.readLine();
					// Grava na console do cliente
					System.out.println(txt);
				}
				
				// Se o comando for sair finaliza a conex√£o
				if (txt != null && txt.endsWith("SAIR"))
					break;
			}
		} catch (IOException ex) {
			System.out.println("Erro durante a conexão: " + ex.getMessage());
		}
	}
}
