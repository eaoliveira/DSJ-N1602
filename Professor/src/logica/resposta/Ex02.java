package logica.resposta;

import javax.swing.JOptionPane;

import fundamentos.resposta.EntradaDados;

public class Ex02 {
	public static void main(String[] args) {
		int nota1 = leNota("Informe a 1ª Nota");
		int nota2 = leNota("Informe a 2ª Nota");;

		double media = (nota1 + nota2) / 2;

		String situacao;
		if(media <= 60) situacao = "insuficiente";
		else if(media <= 80) situacao = "satisfatória";
		else if(media <= 90) situacao=  "boa";
		else situacao = "excelente";
		
		JOptionPane.showMessageDialog(null, situacao);		
	}
	
	 public static int leNota(String msg) {
		 int nota;
		while (true) {
			nota = EntradaDados.leInteiro(msg);
			if (nota < 0 || nota > 100) {
				JOptionPane.showMessageDialog(null, "Valor incorreto!");
			} else {
				break;
			}
		}
		return nota;
	}
}
