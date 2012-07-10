package logica;

import javax.swing.JOptionPane;

public class TesteVetor {
	public static void main(String[] args) {
		Aluno[] lista = new Aluno[40];

		for (int i = 0; i < lista.length; i++) {
			String nome = JOptionPane.showInputDialog("Informe o nome");
			String nota = JOptionPane.showInputDialog("Informe a nota");
			lista[i] = new Aluno(nome, Double.parseDouble(nota));
		}
	}
}

class Aluno {
	String nome; // atributo
	double nota;
	public Aluno(String n, double nt) { // construtor
		nome = n;
		nota = nt;
	}
}