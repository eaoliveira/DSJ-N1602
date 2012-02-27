package logica.resposta;

import javax.swing.JOptionPane;

import fundamentos.resposta.EntradaDados;

public class Ex07 {
	public static void main(String[] args) {
		//double[] classe = new double[3];
		double escola = 0, classe;
		String txt = "Escola 1/2 Boca\n\n";
		
		for (int i = 0; i < 3; i++) {
			classe = 0;
			for (int j = 0; j < 5; j++) {
				classe += EntradaDados.leDouble("Classe: " + (i+1) + " Nota: " + (j+1));
			}
			classe /= 5;
			escola += classe;
		  txt += "Media Classe: " + (i+1) + ": " + classe + "\n";	
		}
		escola /= 3;
		txt += "\nMedia Escola: " + escola;
		
		JOptionPane.showMessageDialog(null, txt);
	}
}
