package Rede.outros.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ServidorMessengerMultiplosClientesChat extends Thread{
	private ServerSocket server = null;
	private Socket skt = null;

	public ServidorMessengerMultiplosClientesChat() {
		try {
			server = new ServerSocket(12345);
			while (true) {
				skt = server.accept();
				new FalaCliente2(skt).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ServidorMessengerMultiplosClientesChat();
	}
}

class FalaCliente2 extends Thread {
	private Socket s;
	static private ArrayList<PrintWriter> listaClientes = new ArrayList<PrintWriter>();

	public FalaCliente2(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			InputStreamReader is = new InputStreamReader(s.getInputStream());
			BufferedReader in = new BufferedReader(is);
			PrintWriter out = new PrintWriter(s.getOutputStream());

			synchronized(listaClientes) {
				listaClientes.add(out);
			}
			
			out.println("Bem vindo " + s.getInetAddress());
			out.flush();
			
			String msg = in.readLine();
			while (!msg.equals("SAIR")) {
				//msg = in.readLine();
				for(PrintWriter cadaCliente : listaClientes){
					cadaCliente.println(msg);
					cadaCliente.flush();
				}
				msg = in.readLine();
			}
			
			listaClientes.remove(out);
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
