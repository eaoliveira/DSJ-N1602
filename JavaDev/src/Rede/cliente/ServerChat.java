package Rede.cliente;

import java.io.*;
import java.net.*;

public class ServerChat extends Thread {
	private Socket skt;
	
	public ServerChat(Socket skt) {
		this.skt = skt;
	}

	public static void main(String[] args) {
		try {
			ServerSocket srv = new ServerSocket(1234);
			while (true) {
				Socket skt = srv.accept();
				ServerChat server = new ServerChat(skt);
				server.start();
			}
		} catch (IOException ex) {
			System.out.println("Erro durante a conexão: " + ex.getMessage());
		}
	}

	public void run() {
		try {
			InputStreamReader is = new InputStreamReader(skt.getInputStream());
			BufferedReader in = new BufferedReader(is);
			PrintWriter out = new PrintWriter(skt.getOutputStream());

			out.println("Bem Vindo");
			out.flush();

			String txt = in.readLine();
			while (!txt.equals("SAIR")) {
				out.println(txt);
				out.flush();

				txt = in.readLine();
			}
			skt.close();

		} catch (IOException ex) {
			System.out.println("Erro durante a conexão: " + ex.getMessage());
		}

	}
}