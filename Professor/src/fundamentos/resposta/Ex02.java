package fundamentos.resposta;

import javax.swing.JOptionPane;
import static fundamentos.resposta.EntradaDados.*;

public class Ex02 {
	public static void main(String[] args) {
		int qtd1 = leInteiro("Informe a qtd 1");
		int val1 = leInteiro("Informe a val 1");
		int qtd2 = leInteiro("Informe a qtd 2");
		int val2 = leInteiro("Informe a val 2");
		int qtd3 = leInteiro("Informe a qtd 3");
		int val3 = leInteiro("Informe a val 3");
		
		int total = qtd1 * val1 + qtd2 * val2 + qtd3 * val3;
		
		JOptionPane.showMessageDialog(null, 
				"O total é : " + total);
	}
}
