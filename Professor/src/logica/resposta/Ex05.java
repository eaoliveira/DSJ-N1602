package logica.resposta;

import javax.swing.JOptionPane;

import fundamentos.resposta.EntradaDados;

public class Ex05 {
	public static void main(String[] args) {
		int[] num = new int[5];
		for (int i = 0; i < num.length; i++) 
			num[i] = EntradaDados.leInteiro("Informe o "+(i+1)+" numero");
		
		java.util.Arrays.sort(num);
		
		String txt = "Lista de Numeros\n\n";
		for (int i = num.length-1; i >= 0 ; i--) 
		  txt += num[i] + " ";
		
		JOptionPane.showMessageDialog(null, txt);
	}
}
