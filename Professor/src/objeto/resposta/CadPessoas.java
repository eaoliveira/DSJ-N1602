package objeto.resposta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

import objeto.respostas.Endereco;
import objeto.respostas.Pessoa;
import objeto.respostas.PessoaFisica;
import objeto.respostas.PessoaJuridica;

public class CadPessoas {
	public static void main(String[] args) {
		ArrayList<Pessoa> lista = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			int op = JOptionPane.showOptionDialog(null, 
					"Selecione o tipo de Pessoa",
					"Cad Pessoas", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, 
					new String[] { "Fisica",	"Juridica" }, "Fisica");

			if (op == 0) {
				PessoaFisica p = new PessoaFisica();
				p.setNome(JOptionPane.showInputDialog("Informe o nome"));
				p.setFone(JOptionPane.showInputDialog("Informe o Fone"));
				p.setRg(JOptionPane.showInputDialog("Informe o RG"));
				p.setCpf(JOptionPane.showInputDialog("Informe o CPF"));
				p.setEmail(JOptionPane.showInputDialog("Informe o E-Mail"));

				p.setEndereco(cadEndereco());

				lista.add(p);
			} else 	if (op == 1) {
				PessoaJuridica p = new PessoaJuridica();
				p.setNome(JOptionPane.showInputDialog("Informe o nome"));
				p.setFone(JOptionPane.showInputDialog("Informe o Fone"));
				p.setCnpj(JOptionPane.showInputDialog("Informe o CNPJ"));
				p.setInscrEst(JOptionPane.showInputDialog("Informe o I.E."));
				p.setSite(JOptionPane.showInputDialog("Informe o Site"));

				p.setEndereco(cadEndereco());

				lista.add(p); // Adiciona
			} else {
				break;
			}
		}
		
		// ordena por  Nome
		Collections.sort(lista);
		
		String txt = "Cadastro de Pessoas\n\n";
		for (int i = 0; i < lista.size(); i++) {
			txt = txt + lista.get(i) + "\n";
		}
		JOptionPane.showMessageDialog(null, txt);
		
		// ordena por Tipo e Nome
		Collections.sort(lista, new MeuComparador());
		
		txt = "Cadastro de Pessoas\n\n";
		for (int i = 0; i < lista.size(); i++) {
			txt = txt + lista.get(i) + "\n";
		}
		JOptionPane.showMessageDialog(null, txt);
	}

	public static Endereco cadEndereco() {
		Endereco end = new Endereco();
		end.setLogradouro(JOptionPane.showInputDialog("informe o Logr."));
		end.setNumero(JOptionPane.showInputDialog("informe o N."));
		end.setComplemento(JOptionPane.showInputDialog("informe o Compl."));
		end.setBairro(JOptionPane.showInputDialog("informe o Bairro"));
		end.setCep(JOptionPane.showInputDialog("informe o CEP"));
		end.setCidade(JOptionPane.showInputDialog("informe o Cidade"));
		end.setEstado(JOptionPane.showInputDialog("informe o Estado"));
		return end;
	}

}

class MeuComparador implements Comparator<Pessoa> {
	public int compare(Pessoa o1, Pessoa o2) {
		int tipoObj1 = o1 instanceof PessoaFisica ? 0 : 1; 
		int tipoObj2 = o2 instanceof PessoaFisica ? 0 : 1; 

		int ret = tipoObj1 - tipoObj2;
		
		if(ret == 0) 
						ret = o1.getNome().compareTo(o2.getNome());
		
		return ret;
	}
}
