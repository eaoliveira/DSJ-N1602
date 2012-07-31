package objeto.resposta;

import javax.swing.JOptionPane;

import objeto.respostas.Endereco;
import objeto.respostas.Pessoa;

public class CadPessoa {
	public static void main(String[] args) {
		Pessoa[] lista = new Pessoa[2];

		for (int i = 0; i < lista.length; i++) {
			String nome = JOptionPane.showInputDialog("informe o Nome");
			String fone = JOptionPane.showInputDialog("informe o fone");

			Pessoa p = new Pessoa();
			p.setNome(nome);
			p.setFone(fone);

			Endereco end = new Endereco();
			end.setLogradouro(JOptionPane.showInputDialog("informe o Logr."));
			end.setNumero(JOptionPane.showInputDialog("informe o N."));
			end.setComplemento(JOptionPane.showInputDialog("informe o Compl."));
			end.setBairro(JOptionPane.showInputDialog("informe o Bairro"));
			end.setCep(JOptionPane.showInputDialog("informe o CEP"));
			end.setCidade(JOptionPane.showInputDialog("informe o Cidade"));
			end.setEstado(JOptionPane.showInputDialog("informe o Estado"));
			p.setEndereco(end);

			lista[i] = p;
		}

		String txt = "";
		for (int i = 0; i < lista.length; i++) {
			txt = txt + lista[i].toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, txt);
	}
}
