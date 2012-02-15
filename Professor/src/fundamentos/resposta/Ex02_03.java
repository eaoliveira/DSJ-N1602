package fundamentos.resposta;

import javax.swing.JOptionPane;

public class Ex02_03 {
  public static void main(String[] args) {
		int larg = EntradaDados.leInteiro("Informe a largura");
		int comp = EntradaDados.leInteiro("Informe o comprimento");
		
		JOptionPane.showMessageDialog(null, "Área Total: " + 
		  (larg * comp));
	}
}
