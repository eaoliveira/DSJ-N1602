package logica.resposta;

import java.util.Locale;

import javax.swing.JOptionPane;

import fundamentos.resposta.EntradaDados;

public class Ex01 {
	public static void main(String[] args) {
		int qtdHoras = EntradaDados.leInteiro("Informe a Qtd de Horas Trab.");
		double salHoras = EntradaDados.leDouble("Informe o Sal. Hora");
		int numDep = EntradaDados.leInteiro("Informe o Nº de Dep.");

		double salBruto = qtdHoras * salHoras + (50 * numDep);
		String msg = String.format(
				new Locale("pt", "BR"),
				"Sal. Bruto: R$ %,.2f\n", salBruto);
		
		double inss;
		if (salBruto <= 1000)
			inss = salBruto * 8.5 / 100;
		else
			inss = salBruto * 9.0 / 100;
		
		msg += String.format("INSS: R$ %,.2f\n", inss);

		double ir;
		if (salBruto <= 500)
			ir = 0;
		else if (salBruto <= 1000)
			ir = salBruto * 5.0 / 100;
		else
			ir = salBruto * 7.0 / 100;

		msg += String.format("IR: R$ %,.2f\n", ir);

		double salLiq = salBruto - inss - ir;
		msg += String.format("Sal. Liquido: R$ %,.2f", salLiq);

		JOptionPane.showMessageDialog(null, msg);
	}
}
