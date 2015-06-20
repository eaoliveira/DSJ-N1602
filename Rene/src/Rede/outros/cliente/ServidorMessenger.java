package Rede.outros.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMessenger extends Thread{

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(1234);
			
			Socket s = server.accept();
			InputStreamReader is = new InputStreamReader(s.getInputStream());
			BufferedReader in = new BufferedReader(is);
			PrintWriter out = new PrintWriter(s.getOutputStream());
			
			out.println("Bem vindo " + s.getInetAddress());
			out.flush();
			
			while(true){
				String msg = in.readLine();
				out.println("S:" + msg);
				out.flush();
			}
			
			
			//s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void run() {
		
	}
}
