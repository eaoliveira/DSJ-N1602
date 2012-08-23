package api.datas;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JOptionPane;

public class TesteData3 {
	public static void main(String[] args) {
		try {
			String txt = JOptionPane.showInputDialog("Informe uma data");
			DateFormat dfEntrada = DateFormat.getDateInstance();
			dfEntrada.setLenient(false);
			DateFormat dfSaida = DateFormat.getDateInstance(DateFormat.FULL);
			Date data = dfEntrada.parse(txt);
			
			System.out.println(dfSaida.format(data));
		} catch (ParseException ex) {
			JOptionPane.showMessageDialog(null, "Data Inválida");
		}
	}
}
