package fundamentos.resposta;

import javax.swing.JOptionPane;
import static fundamentos.resposta.EntradaDados.*;

public class Ex05_2 {
	public static void main(String[] args) {
		int total = leInteiro("Inf. a largura") *
		                 leInteiro("Inf. o comprimento") *
			               leInteiro("Inf. a profundidade") * 45;
		JOptionPane.showMessageDialog(null, 
				"O Preço final é R$ " + total);
	}
}
