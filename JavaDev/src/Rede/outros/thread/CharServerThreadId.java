package Rede.outros.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CharServerThreadId extends Thread {
	private Socket s = null;
	private int id = 0;
	private static List<Socket> lista = new ArrayList<Socket>();

	public CharServerThreadId(Socket skt, int id) {
		s = skt;
		this.id = id;
		synchronized (lista) {
			lista.add(s);
		}
	}

	public void run() {
		try {
			InputStreamReader is = new InputStreamReader(s.getInputStream());
			BufferedReader in = new BufferedReader(is);
			PrintWriter out = new PrintWriter(s.getOutputStream());
			// String id = in.readLine();
			out.println("Bem Vindo " + id);
			out.flush();

			String msg = "";
			while (msg != null && !msg.equals("SAIR")) {
				msg = in.readLine();

				synchronized (lista) {
					for (int i = 0; i < lista.size(); i++) {
						Socket s2 = lista.get(i);
						PrintWriter sout = new PrintWriter(s2.getOutputStream());
						sout.println(id + ":" + msg);
						sout.flush();
					}
				}

			}
			synchronized (lista) {
				lista.remove(s);
			}
			s.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(1234);
			for (int i = 1;; i++) {
				Socket s = server.accept();
				CharServerThreadId c = new CharServerThreadId(s, i);
				c.start();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (server != null)
					server.close();
			} catch (Exception e) {
			}
		}
	}
}