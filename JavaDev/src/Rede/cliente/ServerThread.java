package Rede.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread extends Thread {
	private int id;
	private Socket skt;
	// Armazena os output Streams de todas as Threas
	private static List<PrintWriter> lista = new ArrayList<PrintWriter>();

	public ServerThread(Socket skt, int id) {
		this.skt = skt;
		this.id = id;
	}

	public void run() {
		try {
			InputStreamReader is = new InputStreamReader(skt.getInputStream());
			BufferedReader in = new BufferedReader(is);
			PrintWriter out = new PrintWriter(skt.getOutputStream());

			// incluir o out na lista
			synchronized (lista) {
				lista.add(out);
			}

			out.println("Bem Vindo");
			out.flush();

			String txt = in.readLine();
			while (!txt.equals("SAIR")) {
				// acessar o out para gravar
				synchronized (lista) {
					//for (PrintWriter out2 : lista) {
					for(int i = 0;i < lista.size();i++) {
						PrintWriter out2 = lista.get(i);
						out2.println(id + ": " + txt);
						out2.flush();
					}
				}
				txt = in.readLine();
			}

			// retirar o out da lista
			synchronized (lista) {
				lista.remove(out);
			}
			skt.close();

		} catch (IOException ex) {
			System.out.println("Erro durante a conexão: " + ex.getMessage());
		}

	}

	public static void main(String[] args) {
		try {
			ServerSocket srv = new ServerSocket(1234);
			for (int i = 1;;i++) {
				Socket skt = srv.accept();
				ServerThread server = new ServerThread(skt,i);
				server.start();
			}
		} catch (IOException ex) {
			System.out.println("Erro durante a conexão: " + ex.getMessage());
		}
	}

}
