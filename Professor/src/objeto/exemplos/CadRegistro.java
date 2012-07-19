package objeto.exemplos;

import javax.swing.JOptionPane;

import fundamentos.resposta.EntradaDados;

public class CadRegistro {
	public static void main(String[] args) {
		Registro[] lista = new Registro[2];

		for (int i = 0; i < lista.length; i++) {
			String nome = JOptionPane.showInputDialog("Informe o nome");
			int idade = EntradaDados.leInteiro("Informe a Idade");
			String email = JOptionPane.showInputDialog("Informe o Email");

			Registro primeiroRegistro = new Registro();
			primeiroRegistro.setNome(nome);
			primeiroRegistro.setIdade(idade);
			primeiroRegistro.setEmail(email);
			
			lista[i] = primeiroRegistro;
		}
		
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}
	}
}
