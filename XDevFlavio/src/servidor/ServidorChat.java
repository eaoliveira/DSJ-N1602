package servidor;

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
		
		try {
			
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(1234);
			
			int cont = 0;
			while (true) {
				Socket sk = server.accept();
				cont += 1; 
				ClienteServidor cs = new ClienteServidor(sk, cont);
				Thread th = new Thread(cs);
				th.start();
			}			
			
			
		} catch (IOException ex) {
			ex.printStackTrace();
			ex.getMessage();
		}
		
	}
}

class ClienteServidor implements Runnable {
	
	private static List<PrintWriter> listOut = new ArrayList<PrintWriter>();
	private Socket sk;
	private int cont;
	
	public ClienteServidor(Socket sk, int cont) {
		this.sk = sk;
		this.cont = cont;		
	}
	
	@Override
	public void run() {
		
		try {
			
			PrintWriter out = new PrintWriter(sk.getOutputStream());
			BufferedReader in = new BufferedReader(
					new InputStreamReader(sk.getInputStream()));
			
			synchronized (listOut) {
				listOut.add(out);
			}
			
			out.println("Testando Servidor AA852746BB - Cliente #" + cont);
			out.flush();
			String txt = in.readLine();
			
			while (txt != "A99652871") {
				
				synchronized (listOut) {
					for (PrintWriter i : listOut) {
						i.println("Cliente #" +cont +": " + txt);
						i.flush();
						txt = in.readLine();
					
					}
					
				}
			}
			
			sk.close();
			
		} catch (IOException ex) {
			ex.printStackTrace();
			ex.getMessage();
		}
		
	}
	
}

