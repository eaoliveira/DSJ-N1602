package Rede.old.abs;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import Rede.old.abs.base.AbstractHandler;
import Rede.old.abs.base.AbstractServer;

@SuppressWarnings("serial")
public class ObjetoServer extends AbstractServer {

	public ObjetoServer() {
		super("Objeto Server");
	}

	public void run() {
		try {
			server = new ServerSocket(porta);

			while (true) {
				try {
					Socket s = server.accept();

					synchronized (ta) {
						ta.append("aceitando conexão de " + s.getInetAddress() + "\n");
					}

					new ObjetoClient(s).start();
				} catch (SocketException ex) {
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	class ObjetoClient extends AbstractHandler {
		public ObjetoClient(Socket s) throws IOException {
			super(s);
		}

		public void run() {
			String ip = sckt.getInetAddress().toString();

			try (ObjectInputStream oin = new ObjectInputStream(sckt.getInputStream());) {
				while (true) {
					try {
						Object p = (Object) oin.readObject();

						synchronized (ta) {
							if (p instanceof java.util.List) {
								for (Object obj : (java.util.List<?>) p) {
									ta.append(ip + ": " + obj.toString() + "\n");
								}
							} else {
								ta.append(ip + ": " + p.toString() + "\n");
							}
						}
					} catch (EOFException ex) {
						ta.append("Fim!");
						break;
					}
				}
			} catch (ClassNotFoundException ex) {
				ta.append(ip + "Erro: " + ex.getMessage() + "\n");
				repaint();
				ex.printStackTrace();
			} catch (IOException ex) {
				try {
					ta.append("conexão finalizada com " + ip + "\n");
					sckt.close();
					ex.printStackTrace();
				} catch (IOException e) {
					ta.append("conexão abortada...");
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new ObjetoServer();
	}

}
