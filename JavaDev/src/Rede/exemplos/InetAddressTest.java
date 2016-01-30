package Rede.exemplos;

import java.net.*;
import javax.swing.*;

public class InetAddressTest {
  public static void main(String[] args) {
    try {
      String host = JOptionPane.showInputDialog(null, "Informe o nome do Host");
      InetAddress[] addresses = InetAddress.getAllByName(host);
      
      StringBuffer sb = new StringBuffer();
      for(InetAddress addr: addresses)
        sb.append(addr.toString() + "\n");

      InetAddress localHostAddress = InetAddress.getLocalHost();
      JOptionPane.showMessageDialog(null, "Endereço local: "
        + localHostAddress + "\n\n" + sb);
    } catch(Exception e) {
      JOptionPane.showMessageDialog(null, "Error: " + e);
    }
  }
}