package fundamentos.resposta;

import javax.swing.JOptionPane;

public class Ex04 {
	public static void main(String[] args) {
		int val1 = EntradaDados.leInteiro("Inf. val1");
		int val2 = EntradaDados.leInteiro("Inf. val2");
		int val3 = EntradaDados.leInteiro("Inf. val3");
		int val4 = EntradaDados.leInteiro("Inf. val4");
		int soma = val1 + val2 + val3 + val4;
		String txt = "A média é : " + (soma/4);
	  txt +=  "\n% da "+soma+" por " + val1 + " : " + (soma%val1);
	  txt = txt + "\n% da "+soma+" por " + val2 + " : " + (soma%val2);
	  txt = txt + "\n% da "+soma+" por " + val3 + " : " + (soma%val3);
	  txt = txt + "\n% da "+soma+" por " + val4 + " : " + (soma%val4);
	  
		JOptionPane.showMessageDialog(null, txt);
	}
}
