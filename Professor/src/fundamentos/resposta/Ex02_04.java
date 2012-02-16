package fundamentos.resposta;

import javax.swing.JOptionPane;

public class Ex02_04 {
	public static void main(String[] args) {
		double[] val = new double[4];
		int soma = 0;
		
		for (int i = 0; i < val.length; i++) {
			val[i] = EntradaDados.leInteiro("informe o "+(i+1)+"º valor");
			soma += val[i];  // soma = soma + val[i];
		}

		String msg = "Soma: " + soma + "\nMédia: " + (soma/val.length);
		
		for (int i = 0; i < val.length; i++)
		  msg +=  "\nResto da Div. do "+(i+1)+"º valor ("+val[i]+") pela média: " + (soma%val[i]); 
		
		JOptionPane.showMessageDialog(null, msg);
	}
}
