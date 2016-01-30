package Rede.exemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class TesteServer {
	public static void main(String[] args) {
		try {
			// Inicia a Conexão
			Socket skt = new Socket("localhost", 1234);
			Cliente cli = new Cliente(skt);
			cli.chat();
		} catch (IOException ex) {
			System.out.println("ERRO:\n" + ex.getMessage());
		}
	}
}

class Cliente {
	private Socket skt;

	public Cliente(Socket skt) {
		this.skt = skt;
	}

	public void chat() {
		try {
			// Configura os canais de entrada e saída
			BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			PrintWriter out = new PrintWriter(skt.getOutputStream());

			String msg = "";
			do {
				if (in.ready()) {
					System.out.println(in.readLine());

					msg = JOptionPane.showInputDialog("Msg:");
					out.println(msg);
					out.flush();
				}
			} while (!msg.equals("SAIR"));

			skt.close();
			System.out.println("Fim");
		} catch (IOException ex) {
			System.out.println("ERRO:\n" + ex.getMessage());
		}
	}
}
