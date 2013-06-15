package Rede.cliente;

import java.io.*;
import java.net.*;

public class ClienteSimples {
  public static void main(String[] args) {
    try {
      // Cria um Socket e abre uma conexão a um servidor
      Socket s = new Socket("localhost", 1234);
      // Define um Tempo limite para a conexão
      s.setSoTimeout(10000);
      // Mostra a identificação da conexão
      System.out.println(s.toString());
      // Cria um Leitor para o Socket
      InputStreamReader is = new InputStreamReader(s.getInputStream());
      BufferedReader in = new BufferedReader(is);
      // Cria um Gravador para o Socket
      PrintWriter out = new PrintWriter(s.getOutputStream());

      // Cria um Leitor para o Teclado
      InputStreamReader tis = new InputStreamReader(System.in);
      BufferedReader cons = new BufferedReader(tis);

      // Lê mensagem de boas vindas do Servidor
      System.out.println(in.readLine());

      // Lê os dados do Leitor do Socket
      while(true) {
        // Lê o teclado
        String txt = cons.readLine();
        // Grava um texto no Gravador do Socket
        out.println(txt);
        out.flush();

        // Lê o texto do Servidor
        txt = in.readLine();
        // Grava na console do cliente
        System.out.println(txt);

        // Se o comando for sair finaliza a conex√£o
        if(txt.endsWith("SAIR"))
          break;
      }
      // Fecha a conexão do Socket
      s.close();
    } catch(IOException ex) {
      System.out.println("Erro durante a conexão: " + ex.getMessage());
    }
  }
}
