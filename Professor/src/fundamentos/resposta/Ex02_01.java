package fundamentos.resposta;

import javax.swing.JOptionPane;

public class Ex02_01 {
	public static void main(String[] args) {
		String nome1 = JOptionPane.showInputDialog("Informe o 1º nome");
		String nome2 = JOptionPane.showInputDialog("Informe o 2º nome");
		String nome3 = JOptionPane.showInputDialog("Informe o 3º nome");
		
		JOptionPane.showMessageDialog(null, nome1 + " " + nome3 + "\n" + nome2);
	}
}
