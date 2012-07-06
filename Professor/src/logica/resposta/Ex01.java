package logica.resposta;

import javax.swing.JOptionPane;

import static fundamentos.resposta.EntradaDados.*;

public class Ex01 {
	public static void main(String[] args) {
		int qtd = leInteiro("Informe a qtd de Horas Trabalhadas");
		double salHora = leDouble("Informe o valor do Sal. Hora");
		int dep = leInteiro("Informe o no. de Dependentes");
    String txt = "Calculo de Salario\n";
		
		double salBruto = qtd * salHora + (50 * dep);
    txt += String.format("\nSalario Bruto: R$ %,.2f", salBruto);
		
		double inss;
		if (salBruto <= 1000)
			inss = salBruto * 8.5 / 100;
		else
			inss = salBruto * 9.0 / 100;
    txt += String.format("\nINSS: R$ %,.2f", inss);

		double ir;
		if (salBruto <= 500)
			ir = 0;
		else if (salBruto <= 1000)
			ir = salBruto * 5.0 / 100;
		else
			ir = salBruto * 7.0 / 100;
		txt +=  String.format("\nIR: R$ %,.2f", ir);
		
		double salLiq = salBruto - inss - ir;
		txt +=  String.format("\nSalario Liquido: R$ %,.2f", salLiq); 
		
		JOptionPane.showMessageDialog(null, txt);
	}
}
