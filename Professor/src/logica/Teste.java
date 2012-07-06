package logica;

import javax.swing.JOptionPane;

public class Teste {
	public static void main(String[] args) {
		
		/*
		 *  salario
		 *  
		 *  se sal entre 500 e 1000 dá abono de 100
		 *  se sal entre 1000 e 2000 dá abono de 500
		 *  se sal acima 2000 dá abono de 1000
		 */
		
		
		String temp = JOptionPane.showInputDialog("Informe o salario");
		double sal = Double.parseDouble(temp);
		double abono = 0;
		
		if(sal <= 1000) {
			abono= 100;
		} else if(sal <= 2000) {
			abono = 500;
		} else {
			abono = 1000;
		}
		
		JOptionPane.showMessageDialog(null, "Abono: " + abono + 
				" Salario c/ abono: " + (sal + abono));
	}
}
