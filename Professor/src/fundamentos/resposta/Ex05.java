package fundamentos.resposta;

import javax.swing.JOptionPane;
import static fundamentos.resposta.EntradaDados.*;

public class Ex05 {
	public static void main(String[] args) {
		int larg = leInteiro("Inf. a largura");
		int comp = leInteiro("Inf. o comprimento");
		int prof = leInteiro("Inf. a profundidade");
		JOptionPane.showMessageDialog(null, 
				"O Preço final é R$ " + (larg * comp * prof * 45));
	}
}
