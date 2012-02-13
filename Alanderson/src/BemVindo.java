//package introducao;

import javax.swing.JOptionPane;

public class BemVindo {
  public static void main(String[] args) {
    String st = JOptionPane.showInputDialog(null, "Digite seu nome");
    JOptionPane.showMessageDialog(null, st + ": seja bem vindo!");
    System.exit(0);
  }
}
