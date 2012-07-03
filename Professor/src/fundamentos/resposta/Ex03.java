package fundamentos.resposta;

import javax.swing.JOptionPane;

public class Ex03 {
public static void main(String[] args) {
	int larg = 
			EntradaDados.leInteiro("Informe a Largura");
	int comp = 
			EntradaDados.leInteiro("Informe o Comprimento");
	JOptionPane.showMessageDialog(null, 
			"A Área total é "+ (larg * comp));
}
}
