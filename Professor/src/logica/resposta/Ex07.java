package logica.resposta;

import javax.swing.JOptionPane;

import fundamentos.resposta.EntradaDados;

public class Ex07 {
	public static void main(String[] args) {
		int[] classe = new int[3];
		int mediaEscola = 0;
		String txt = "Media da Escola 1/2 Boca\n\n";
		for (int i = 0; i < classe.length; i++) {
			for (int j = 0; j < 5; j++) 
				classe[i] += EntradaDados.leInteiro("Informe a nota do "+ (j+1)+". aluno da classe "+(i+1));
			classe[i] /= 5;
			txt += "Media da Classe " + (i + 1) + ": " + classe[i] + "\n";
			mediaEscola += classe[i];
		}
		mediaEscola /= classe.length;
		txt += "Media da Escola : " + mediaEscola;
		
		JOptionPane.showMessageDialog(null, txt);
	}
}
