package objeto.resposta;

import javax.swing.JOptionPane;

public class CadPessoa {
	public static void main(String[] args) {
		Pessoa[] lista = new Pessoa[3];

		for (int i = 0; i < lista.length; i++) {
			Pessoa p = new Pessoa();
			String aux = JOptionPane.showInputDialog("Informe o Nome");
			p.setNome(aux);
	    Endereco e = new Endereco();
	    aux = JOptionPane.showInputDialog("informe o Logr.");
	    e.setLogradouro(aux);
	    aux = JOptionPane.showInputDialog("informe o No.");
	    e.setNumero(aux);
	    aux = JOptionPane.showInputDialog("informe o Compl.");
	    e.setComplemento(aux);
	    aux = JOptionPane.showInputDialog("informe o Bairro");
	    e.setBairro(aux);
	    aux = JOptionPane.showInputDialog("informe o CEP");
	    e.setCep(aux);
	    aux = JOptionPane.showInputDialog("informe o Cidade");
	    e.setCidade(aux);
	    aux = JOptionPane.showInputDialog("informe o Estado");
	    e.setEstado(aux);
	    p.setEndereco(e);
			aux = JOptionPane.showInputDialog("Informe o Fone");
			p.setFone(aux);
			lista[i] = p;
		}
		
	java.util.Arrays.sort(lista);
	
		String txt = "Cad de Pessoas\n\n";
		for (Pessoa p : lista) 
			txt += p + "\n";
		
		JOptionPane.showMessageDialog(null, txt);
	}
}
