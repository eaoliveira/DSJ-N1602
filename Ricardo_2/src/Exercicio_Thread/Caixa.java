package Exercicio_Thread;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class Caixa extends Thread{
	
 String tipo_de_cliente;
 String caixa_numero;
	

	public Caixa(String tipo_de_cliente, String caixa_numero) {
		tipo_de_cliente = tipo_de_cliente;
		caixa_numero = caixa_numero;	
	}
	
	
	public synchronized void run(){
					
	try {
		
		
		System.out.println(caixa_numero);
		
		while (Integer.parseInt(Agencia.texto1.getText()) + Integer.parseInt(Agencia.texto2.getText()) > 0) {
		System.out.println(caixa_numero);
			if (caixa_numero == "caixa1") {
				Agencia.texto3.setText("Vazio");
			}
		Thread.sleep(1);
		}
		
		if (tipo_de_cliente == "Preferencial" && (Integer.parseInt(Agencia.texto1.getText())>0)) {
			Agencia.texto1.setText(Integer.toString((Integer.parseInt(Agencia.texto1.getText())-1)));
			Agencia.texto3.setText("Ocupado");
		}
		else {
				
		}
	Thread.sleep(1000);
		

	}
 catch (InterruptedException | NumberFormatException ex) {

}	

}
	
}