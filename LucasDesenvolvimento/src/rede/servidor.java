package rede;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class servidor {
	public static void main(String[] args) {
		try (ServerSocket sever = new ServerSocket(1234);) {
			while (true) {
				Socket skt = sever.accept();
				new ThreadCliente(skt).start();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

class ThreadCliente extends Thread {
	private Socket skt;
	public static List<PrintWriter> listout = new ArrayList<PrintWriter>();

	public ThreadCliente(Socket skt) {
		this.skt = skt;
	}

	public void run() {
		try {
			InputStreamReader is = new InputStreamReader(skt.getInputStream());
			BufferedReader in = new BufferedReader(is);
			PrintWriter out = new PrintWriter(skt.getOutputStream());
			synchronized (listout) {
				listout.add(out);
			}

			out.print("Bem Vindo  " + skt.getInetAddress());
			out.flush();

			String txt = in.readLine();
			while (!txt.equals("SAIR")) {
				synchronized (listout) {
					for (PrintWriter o : listout) {
						o.println("S:" + txt);
						o.flush();
					}
				}
				txt = in.readLine();
			}
			synchronized (listout) {
				listout.remove(out);
			}
			skt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}