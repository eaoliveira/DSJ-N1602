package Rede.outros.cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class PrimeiroServidor {
	private static Socket skt;

	public static void main(String[] args)

	{
		try {
			// Configura a porta do Servidor
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(1234);

			// Estabelecendo conexão com o servidor

			while (true) {
				skt = server.accept();
				new Tredi(skt).start();
			}

		} catch (SocketException ex) {
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

class Tredi extends Thread {
	private static List<PrintWriter> listaClientes = new ArrayList<>();
	private Socket skt;

	public Tredi(Socket skt) {
		this.skt = skt;
	}

	@Override
	public void run() {
		try {
			// Obtendo os canais de Entrada e Saida
			PrintWriter out = new PrintWriter(skt.getOutputStream());
							
				synchronized(listaClientes) {
					listaClientes.add(out);
				}
				
				
				
			// Fechar a conexão
			//skt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
