package api.datas.respostas;

import java.util.Calendar;

import javax.swing.JOptionPane;

public class DiaAtual_1 {
	public static void main(String[] args) {
		// Terça-feira, dia 22 de Agosto de 2006.
		Calendar cal = Calendar.getInstance();
		// cal.set(2006, Calendar.AUGUST, 22);
		//Date d = cal.getTime();

		JOptionPane.showMessageDialog(null,
				String.format("Hoje é %1$tA, dia %1$te de %1$tB de %1$tY.", cal));
	}
}
