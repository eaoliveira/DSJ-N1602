package objeto.respostas;

import javax.swing.JOptionPane;

public class CadPessoa {
	public static void main(String[] args) {
		Pessoa[] lista = new Pessoa[3];

		for (int i = 0; i < lista.length; i++) {
			Pessoa obj = new Pessoa();
			obj.setNome(JOptionPane.showInputDialog("Informe o Nome"));
			obj.setEndereco(JOptionPane.showInputDialog("Informe o End."));
			obj.setTelefone(JOptionPane.showInputDialog("Informe o Fone"));
			lista[i] = obj;
		}
		
		String msg = "Cad. Pessoas\n\n";
		for (Pessoa obj : lista)
			msg += obj + "\n";
		JOptionPane.showMessageDialog(null, msg);
	}
}
