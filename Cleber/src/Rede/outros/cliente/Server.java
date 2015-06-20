package Rede.outros.cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {

			ServerSocket sS = new ServerSocket(1234);
			Socket socket = sS.accept();

			InputStreamReader in = new InputStreamReader(
					socket.getInputStream());

			BufferedReader bfR = new BufferedReader(in);

			PrintWriter out = new PrintWriter(socket.getOutputStream());

			out.println(socket.getInetAddress());
			out.flush();

			out.println("s" + bfR.readLine());
			out.flush();
			socket.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
