package logica.resposta;

import javax.swing.JOptionPane;

import fundamentos.resposta.EntradaDados;

public class Ex04 {
	public static void main(String[] args) {
		int mes;
		do {
			mes = EntradaDados.leInteiro("Informe o no. do mes");
			String msg = "";
			switch (mes) {
			case 1:
				msg = "Janeiro";
				break;
			case 2:
				msg = "Fevereiro";
				break;
			case 3:
				msg = "Marco";
				break;
			case 4:
				msg = "Abril";
				break;
			case 5:
				msg = "Maio";
				break;
			case 6:
				msg = "Junho";
				break;
			case 7:
				msg = "Julho";
				break;
			case 8:
				msg = "Agosto";
				break;
			case 9:
				msg = "Setembro";
				break;
			case 10:
				msg = "Outubro";
				break;
			case 11:
				msg = "Novembro";
				break;
			case 12:
				msg = "Dezembro";
				break;
			default:
				msg = "Mes Invalido";
			}
			JOptionPane.showMessageDialog(null, msg);
		} while (mes < 1 || mes > 12);
	}
}
