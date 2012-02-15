package fundamentos.resposta;

import javax.swing.JOptionPane;

public class EntradaDados {
	public static int leInteiro(String msg) {
		String aux = JOptionPane.showInputDialog(msg);
    int num = Integer.parseInt(aux);
    return num;
	}
}
