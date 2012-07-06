package logica.resposta;

import javax.swing.JOptionPane;

import static fundamentos.resposta.EntradaDados.*;

public class eX02 {
	public static void main(String[] args) {
		double media = 0;
		int qtd = leInteiro("Informe a qtd de Nota");
		int[] nota = new int[qtd];
		for (int i = 0; i < nota.length; i++)
			media += leNota("Informe a " + (i + 1) + "a. Nota");
		media /= qtd;

		String txt = String.format("Media : %,.2f\n", media);
		if (media <= 60)
			txt += "insuficiente";
		else if (media <= 80)
			txt += "satisfatória";
		else if (media <= 90)
			txt += "boa";
		else
			txt += "excelente";

		JOptionPane.showMessageDialog(null, txt);
	}

	public static double leNota(String texto) {
		double nota = leDouble(texto);
		while (nota < 0 || nota > 100) {
			JOptionPane.showMessageDialog(null, "Nota Invalida!");
			nota = leDouble(texto);
		}
		return nota;
	}
}
