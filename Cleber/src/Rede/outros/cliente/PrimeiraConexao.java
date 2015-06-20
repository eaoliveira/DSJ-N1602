package Rede.outros.cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PrimeiraConexao {
	public static void main(String[] args) {
		try {
			// Estabelecendo conexão com o servidor
			Socket skt = new Socket("10.84.144.250", 1234);

			// Obtendo os canais de Entrada e Saida
			PrintWriter out = new PrintWriter(skt.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(
					skt.getInputStream()));

			// Input Stream associado a console
			BufferedReader cons = new BufferedReader(new InputStreamReader(
					System.in));

			// ler dados do servidor
			System.out.println(in.readLine());

			while (true) {
				// mostra o prompt para o usuário
				System.out.print("msg: ");
				// lê o texto digitado pelo usuário
				String txt = cons.readLine();

				out.println(txt);
				out.flush();

				// lê o texto do servidor
				txt = in.readLine();
				System.out.println(txt);

				if (txt.endsWith("SAIR"))
					break;
			}

			// Fechar a conexão
			skt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
