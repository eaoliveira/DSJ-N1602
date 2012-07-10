package logica;

import javax.swing.JOptionPane;

public class TesteVetor2 {
	public static void main(String[] args) {
		double[] lista = new double[40];

		for (int i = 0; i < lista.length; i++) {
			String nota = JOptionPane.showInputDialog("Informe a nota");
			lista[i] = Double.parseDouble(nota);
		}
	}
}

