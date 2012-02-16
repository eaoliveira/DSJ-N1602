package fundamentos.resposta;

import javax.swing.JOptionPane;

public class Ex02_05 {
	  public static void main(String[] args) {
			int larg = EntradaDados.leInteiro("Informe a largura");
			int comp = EntradaDados.leInteiro("Informe o comprimento");
			int prof = EntradaDados.leInteiro("Informe a profundidade");
			
			int metro = larg * comp * prof;
			
			JOptionPane.showMessageDialog(null, "Valor Total: " + 
			  (metro * 45));
		}
	}
