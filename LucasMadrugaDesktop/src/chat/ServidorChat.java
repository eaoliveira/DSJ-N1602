package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServidorChat {
	public static void main(String[] args) {

		try (ServerSocket server = new ServerSocket(1234);) {
			while (true) {
				Socket skt = server.accept();
				Cliente c = new Cliente(skt);
				Thread t = new Thread(c);
				t.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class Cliente implements Runnable {
	public static List<PrintWriter> listOut = new ArrayList<PrintWriter>();
	private Socket skt;

	public Cliente(Socket skt) {
		this.skt = skt;
	}

	public void run() {
		try {
			PrintWriter out = new PrintWriter(skt.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(
					skt.getInputStream()));
			synchronized (listOut) {
				listOut.add(out);
			}

			out.println("Conectado");
			out.flush();
			String msg = in.readLine();
			
			while (!msg.equals("SAIR")) {
				synchronized (listOut) {
					for (PrintWriter rOut : listOut) {
						rOut.println(msg);
						rOut.flush();
					}
				}
				msg = in.readLine();
			}
			synchronized (listOut) {
				listOut.remove(out);
			}
			skt.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
