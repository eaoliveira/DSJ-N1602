package Rede;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextArea;

public class Conexao_Cliente implements Runnable {
	private Socket skt;
	private JTextArea t_a;
	private PrintWriter out;
	//private Scanner in;
	private BufferedReader in;
	private Thread t;

	public Conexao_Cliente(JTextArea t_a) {
		this.t_a = t_a;
		try {
			// Estabelecendo conexão com o servidor
			skt = new Socket("localhost", 1234);

			// Obtendo os canais de Entrada e Saida
			out = new PrintWriter(skt.getOutputStream());
			//in = new Scanner(skt.getInputStream());
			in = new BufferedReader(new InputStreamReader(skt.getInputStream()));

			t = new Thread(this);
			t.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void send(String msg) {
		out.println(msg);
		out.flush();
	}

	public void close() {
		try {
			out.println("Sair");
			out.flush();
			t.interrupt();
			skt.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (!t.isInterrupted()) {
			try {
				if(in.ready())
					t_a.append(in.readLine() + "\n");
				Thread.sleep(100);
			} catch (InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
