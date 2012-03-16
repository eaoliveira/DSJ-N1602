package fundamentos.resposta;

import javax.swing.JOptionPane;

public class EntradaDados {
	public static int leInteiro(String msg) {
		String aux = JOptionPane.showInputDialog(msg);
    int num = Integer.parseInt(aux);
    return num;
	}

	public static double leDouble(String msg) {
		String aux = JOptionPane.showInputDialog(msg);
    double num = Double.parseDouble(aux);
		return num;
	}
}
