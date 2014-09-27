package Rede.abs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ClienteSimples {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 1234);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(s.getOutputStream());

			System.out.println(in.readLine());
			
			
			String txt = "";
			do {
				txt = JOptionPane.showInputDialog("Escreva sua mensagem");
				
				out.println(txt);
				out.flush();
				
				System.out.println(in.readLine());
			} while(!txt.equals("SAIR"));
			
			
			s.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
