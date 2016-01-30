package Rede.exemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Teste {
	public static void main(String[] args) {
		try {
			// Inicia a Conexão
			Socket skt = new Socket("localhost", 1234);

			// Configura os canais de entrada e saída
			BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			PrintWriter out = new PrintWriter(skt.getOutputStream());

			if (in.ready()) {
				System.out.println("Boas Vindas do Servidor: " + in.readLine());
				out.println("teste de acesso");
				out.flush();

				System.out.println("Resposta do Servidor: " + in.readLine());
				out.println("SAIR");
				out.flush();
			}
			skt.close();
			System.out.println("Fim");
		} catch (IOException ex) {
			System.out.println("ERRO:\n" + ex.getMessage());
		}
	}
}
