package Rede.outros.cliente;

import java.awt.List;
import java.net.ServerSocket;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthViewportUI;

public class Server {
	static long cont =0;
	static ArrayList<TrataCliente> lista;
	static  public void maquinasCriadas(){
		System.out.println("Maquinas Criadas(Thread) "+cont);
	}
	static  public void maquinasCriar(){
		cont++;
	}
	static  public void maquinasDestruir(){
		cont--;
		maquinasCriadas();
	}
	
	
	static public synchronized void listaAdiciona(TrataCliente cliente){
		Server.lista.add(cliente);
	}
	
	static	public synchronized void listaRemove(TrataCliente cliente){
		for (int i =0; i >= lista.size();i++) {
			if((TrataCliente)(lista.get(i))== cliente){
				Server.lista.remove(i);
			}
		}
	}
	
	static public synchronized void listaEnviaMensagem(String msg){
		for (TrataCliente trataCliente : lista) {
			if(!msg.startsWith(trataCliente.nome)) {
				trataCliente.out.println(msg);
				trataCliente.out.flush();
			}
		}
	}
	
	public static void main(String[] args) {
		Server.lista = new ArrayList<TrataCliente>();
		try {
			// Estabelecendo conexão com o servidor
			ServerSocket server = new ServerSocket(1234);
			System.out.println("Servidor Aberto");

			while (true) {
				
				// Obtendo os canais de Entrada e Saida

//				Socket s = server.accept();
				TrataCliente trataCliente = new TrataCliente();
				trataCliente.s = server.accept();
				
				trataCliente.tred.start();
				maquinasCriar();
				maquinasCriadas();
				
				
//				InputStreamReader is = new InputStreamReader(s.getInputStream());
//				BufferedReader in = new BufferedReader(is);
//				PrintWriter out = new PrintWriter(s.getOutputStream());
//
//				out.println("Bem vindo " + s.getInetAddress());
//				out.flush();
//
//				out.println("S: " + in.readLine());
//				out.flush();
//				
//				String t = in.readLine();
//				if (t.equals("sair")) {
//					s.close();
//				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
