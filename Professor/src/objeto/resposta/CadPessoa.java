package objeto.resposta;

import javax.swing.JOptionPane;

public class CadPessoa {
	public static void main(String[] args) {
		Pessoa[] lista = new Pessoa[3];

		for (int i = 0; i < lista.length; i++) {
			Pessoa p = new Pessoa();
			String aux = JOptionPane.showInputDialog("Informe o Nome");
			p.setNome(aux);
			aux = JOptionPane.showInputDialog("Informe o End.");
			p.setEndereco(aux);
			aux = JOptionPane.showInputDialog("Informe o Fone");
			p.setFone(aux);
			lista[i] = p;
		}
		
		String txt = "Cad de Pessoas\n\n";
		for (Pessoa p : lista) 
			txt += p + "\n";
		
		JOptionPane.showMessageDialog(null, txt);
	}
}
