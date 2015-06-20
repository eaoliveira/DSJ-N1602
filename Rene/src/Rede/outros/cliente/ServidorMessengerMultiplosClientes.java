package Rede.outros.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMessengerMultiplosClientes {
	private ServerSocket server = null;
	private Socket skt = null;

	public ServidorMessengerMultiplosClientes() {
		try {
			server = new ServerSocket(1234);
			while (true) {
				skt = server.accept();
				new FalaCliente(skt).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ServidorMessengerMultiplosClientes();
	}
}

class FalaCliente extends Thread {
	private Socket s;
	
	public FalaCliente(Socket s) {
		this.s = s;
	}
	
	@Override
	public void run() {
		try {
			InputStreamReader is = new InputStreamReader(s.getInputStream());
			BufferedReader in = new BufferedReader(is);
			PrintWriter out = new PrintWriter(s.getOutputStream());
			
			out.println("Bem vindo " + s.getInetAddress());
			out.flush();

			String msg = in.readLine();
			while (!msg.equals("SAIR")) {
				out.println("S:" + msg);
				out.flush();

				msg = in.readLine();
			}

			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
