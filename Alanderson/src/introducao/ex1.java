package introducao;

import javax.swing.JOptionPane;

public class ex1 {
  public static void main(String[] args) {
    String n1 = JOptionPane.showInputDialog(null, "Digite seu nome");
    String n2 = JOptionPane.showInputDialog(null, "Digite seu nome");
    String n3 = JOptionPane.showInputDialog(null, "Digite seu nome");
    JOptionPane.showMessageDialog(null, n1 + " " + n2 + "\n" + n3);
  }
}
