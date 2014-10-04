package Rede.abs;

import java.io.*;
import java.net.*;
import java.util.*;

import Rede.abs.base.AbstractHandler;


class Chat extends AbstractHandler {
  private static Vector<Chat> clientes = new Vector<Chat>();
  private BufferedReader in = null;
  private BufferedWriter out = null;

  public Chat(Socket s) throws IOException {
    super(s);
  }

  public void run() {
    try {
      in = new BufferedReader(new InputStreamReader(sckt.getInputStream()));
      out = new BufferedWriter(new OutputStreamWriter(sckt.getOutputStream()));

      clientes.addElement(this);

      while(true) {
        String msg = in.readLine();

        synchronized(clientes) {
          for(Chat c : clientes) {
            try {
              synchronized(c.out) {
                c.out.write(sckt.getInetAddress().toString() + ": " + msg + "\n");
              }
              
              c.out.flush();
            } catch(IOException ex) {
              c.interrupt();
            }
          }
        }
      }
    } catch(IOException ex) {
      clientes.removeElement(this);

      try {
        sckt.close();
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
  }
}
