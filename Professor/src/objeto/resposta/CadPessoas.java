package objeto.resposta;

import javax.swing.JOptionPane;

public class CadPessoas {
	public static void main(String[] args) {
		Pessoa[] lista = new Pessoa[3];
		
		for (int i = 0; i < lista.length; i++) {
			int op = JOptionPane.showOptionDialog(null, "Selecione o Tipo de Pessoa",
							"Cad. Pessoas", JOptionPane.DEFAULT_OPTION, 
							JOptionPane.QUESTION_MESSAGE, null, 
							new String[] { "Fisica", "Juridica" }, "Fisica");
			if(op == 0) {
				PessoaFisica pf = new PessoaFisica();
				lista[i] = pf;
				cadPessoa(pf);
			} else if(op == 1) {
				PessoaJuridica pj = new PessoaJuridica();
				lista[i] = pj;
				cadPessoa(pj);
			}
		}
		
		String txt = "Cad de Pessoas\n\n";
		for (Pessoa p : lista) 
			txt += p + "\n";
		
		JOptionPane.showMessageDialog(null, txt);
	}
	public static void cadPessoa(Pessoa p) {
    String aux = JOptionPane.showInputDialog("informe o nome");
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
    aux = JOptionPane.showInputDialog("informe o fone");
    p.setFone(aux);
		
    if(p instanceof PessoaFisica) {
    	PessoaFisica pf = (PessoaFisica) p;
    	aux = JOptionPane.showInputDialog("informe o RG");
    	pf.setRg(aux);
    	aux = JOptionPane.showInputDialog("informe o CPF");
    	pf.setCpf(aux);
    	aux = JOptionPane.showInputDialog("informe o E-Mail");
    	pf.setEmail(aux);
    } else {
     	PessoaJuridica pj = (PessoaJuridica) p;
    	aux = JOptionPane.showInputDialog("informe o CNPJ");
    	pj.setCnpj(aux);
    	aux = JOptionPane.showInputDialog("informe o Inscr. Est.");
    	pj.setIncrEst(aux);
    	aux = JOptionPane.showInputDialog("informe o Site");
    	pj.setSite(aux);
    }
	}
}
