package Rede;

import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(1234);){
			
			while (true) {
				Socket s = server.accept();
				new Thread(new Server_Socket(s)).start();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

class Server_Socket implements Runnable {
	private Socket s;
	public static List<PrintWriter> listout = new ArrayList<PrintWriter>();

	public Server_Socket(Socket x) {
		s = x;
	}

	public void run() {
		try {
			InputStreamReader is = new InputStreamReader(s.getInputStream());
			BufferedReader in = new BufferedReader(is);
			PrintWriter out = new PrintWriter(s.getOutputStream());
			synchronized (listout) {
				listout.add(out);
			}

			out.println("Bem Vindo" + s.getInetAddress());
			String txt = in.readLine();

			// ler dados do servidor
			// System.out.println(in.readLine());

			while (!txt.equals("Sair")) {
				synchronized (listout) {
					for (PrintWriter o: listout) {
						o.println("S:" + txt);
						o.flush();
					}

			}
				txt = in.readLine();
			}

			// Fechar a conexão
			s.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
