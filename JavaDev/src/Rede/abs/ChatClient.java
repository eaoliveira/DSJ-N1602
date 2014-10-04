package Rede.abs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Rede.abs.base.AbstractClient;

@SuppressWarnings("serial")
public class ChatClient extends AbstractClient {
  private JTextField tf = new JTextField(30);
  private BufferedReader in = null;
  private BufferedWriter out = null;

  public ChatClient() {
    super("Chat Client");

    JPanel p1 = new JPanel();
    p1.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
    p1.add(tf);
    add(p1);

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
    tf.requestFocus();
  }

  public void run() {
    try {
      while(true)
        ta.append(in.readLine() + "\n");
    } catch(IOException ex) {
    } finally {
      try {
        out.close();
      } catch(IOException ex) {
        System.err.println("Erro: " + ex.getMessage());
        ex.printStackTrace();
      }
    }
  }

  protected void inicializaSocket(String servidor, int porta) throws UnknownHostException, IOException {
    sckt = new Socket(servidor, porta);
    this.in = new BufferedReader(new InputStreamReader(sckt.getInputStream()));
    this.out = new BufferedWriter(new OutputStreamWriter(sckt.getOutputStream()));
  }

  protected void gravaDados() throws IOException {
    out.write(tf.getText());
    out.flush();
    tf.setText("");
  }

  public static void main(String[] args) {
    new ChatClient();
  }
}
