package Rede.abs.base;

import java.io.*;
import java.net.Socket;

public abstract class AbstractHandler extends Thread {
  protected Socket sckt = null;

  public AbstractHandler(Socket s) throws IOException {
    sckt = s;
  }

  public AbstractHandler(ThreadGroup tg, Socket s) throws IOException {
    super(tg, s.getInetAddress().toString());
    sckt = s;
  }

  public abstract void run();
}
