package fundamentos.resposta;

import javax.swing.JOptionPane;
import static fundamentos.resposta.EntradaDados.*;

public class Ex05_3 {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, 
				"O Preço final é R$ " + (
				leInteiro("Inf. a largura") *
        leInteiro("Inf. o comprimento") *
        leInteiro("Inf. a profundidade") * 45));
	}
}
