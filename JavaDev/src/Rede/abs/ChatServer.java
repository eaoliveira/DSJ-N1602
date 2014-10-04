package Rede.abs;

import java.io.*;
import java.net.*;

import Rede.abs.base.AbstractServer;


@SuppressWarnings("serial")
public class ChatServer extends AbstractServer {

  public ChatServer() {
    super("Chat Server");
  }

  public void run() {
    try {
      server = new ServerSocket(porta);

      while(true) {
        Socket s = server.accept();
        ta.append("acentando conexão de " + s.getInetAddress() + "\n");
        new Chat(s).start();
      }
    } catch(IOException ex) {
      ta.setText("Erro: " + ex.getMessage() + "\n");
    }
  }

  public static void main(String[] args) {
    new ChatServer();
  }
}
