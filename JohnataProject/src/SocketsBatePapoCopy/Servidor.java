package SocketsBatePapoCopy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Servidor {
	public static void main(String[] args) {

		// Fecha o ServerSocket no fim, quando finalizar o servidor / try
		// (ServerSocket serSkt = new ServerSocket(1234))
		try (ServerSocket serSkt = new ServerSocket(1234)) {
			// Inicia conexão
			while (true) {
				Socket skt = serSkt.accept();
				Cliente cli = new Cliente(skt);
				cli.start();
			}
		} catch (IOException ex) {
			System.out.println("ERRO:\n" + ex.getMessage());
		}
	}
}

class Cliente extends Thread {
	private Socket skt;

	private static List<PrintWriter> lista = new ArrayList<>();

	public Cliente(Socket skt) {
		this.skt = skt;
	}

	public void run() {
		try {
			// Configura os canais de entrada e saída
			BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));

			// Insere o Canal de saída na lista
			PrintWriter out = new PrintWriter(skt.getOutputStream());

			synchronized (lista) {
				// Adiciona o PrinterWriter na lista
				lista.add(out);				
				
			}

			String msg = "Olá! Ben Vindo!";
			out.println(msg);
			out.flush();		
				

			do {
				// Verifica se tem mensagem do Cliente
				if (in.ready()) {
					// Ler a mensagem
					msg = in.readLine();

					// Sincroniza o Objeto para envitar erros na ordem das
					// mensagens, se colocar em toda a lista não funciona, 0 1º
					// segura a lista
					synchronized (lista) {

						// Envia mensagem para cada cliente da lista
						for (int i = 0; i < lista.size(); i++) {
							PrintWriter sout = lista.get(i);
							sout.println(msg);
							sout.flush();
						}

						// Outro modo
						// for (PrintWriter sout : lista){
						// sout.println(msg);
						// sout.flush();
						// }
					}

				}
			} while (!msg.equals("SAIR"));

			synchronized (lista) {
				// Remove o PrinterWriter na lista
				lista.remove(out);
			}
			
			skt.close();
			System.out.println("Fim");

		} catch (IOException ex) {
			System.out.println("ERRO:\n" + ex.getMessage());
		}
	}
}
