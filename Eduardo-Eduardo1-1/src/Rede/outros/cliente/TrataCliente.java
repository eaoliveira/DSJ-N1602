package Rede.outros.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class TrataCliente implements Runnable {
	Thread tred;
	Socket s;
	InputStreamReader is;
	BufferedReader in;
	PrintWriter out;
	String nome;

	// String te;

	public TrataCliente() {
		tred = new Thread(this);
	}

	@Override
	public void run() {

		try {
			is = new InputStreamReader(s.getInputStream());
			in = new BufferedReader(is);
			out = new PrintWriter(s.getOutputStream());
			
			nome = in.readLine();
			
			out.println("Bem vindo " + nome);
			out.flush();
			Server.listaAdiciona(TrataCliente.this);			
			while (!tred.isInterrupted()) {
				if (in.ready()) {
					String msg = in.readLine();
//					out.println("S: " + msg);
//					out.flush();
					Server.listaEnviaMensagem(nome + ": " + msg);

					if (msg.equals("sair")) {
						Server.maquinasDestruir();
						break;
					}
				}

			}
			s.close();

		} catch (IOException e) {
			// } catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		// while (!tred.isInterrupted()) {
		// try {
		// if (recebe.ready())
		// taMensagem.append(recebe.readLine() + "\n");
		// Thread.sleep(100);
		// } catch (IOException ex) {
		// ex.printStackTrace();
		// } catch(InterruptedException e) {
		// }

	}

}
