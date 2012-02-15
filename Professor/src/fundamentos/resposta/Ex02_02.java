package fundamentos.resposta;

import javax.swing.JOptionPane;
import static fundamentos.resposta.EntradaDados.*;

public class Ex02_02 {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Total = " + 
		    leInteiro("informe a qtd1") * leInteiro("informe o valor1") + 
				leInteiro("informe a qtd2") * leInteiro("informe o valor2") + 
				leInteiro("informe a qtd3") * leInteiro("informe o valor3"));
	}
}
