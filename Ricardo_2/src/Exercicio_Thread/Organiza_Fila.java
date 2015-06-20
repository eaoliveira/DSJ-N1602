// THREAD - GERA A QUANTIDADE DE PESSOAS (IDOSAS OU NORMAIS) E ADICIONA NA FILA (JANELA)
package Exercicio_Thread;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Queue;

public class Organiza_Fila extends Thread  {
		
	public synchronized void run() {
		
		Integer x; // Preferencial ID
		Integer y; // Normal ID
		String[][] fila_preferencial = new String[99999][1];
		String[][] fila_normal = new String[99999][1];
		
		try {
			
			x = 0;
			y = 0;
			
			while (!Thread.interrupted()){
			
		Thread.sleep(1000);

		int z = (Integer) Agencia.button3.getValue();
		
		for (int i = 0 ; i<z; i++){
			if (Math.random() > 0.5) {
				x = x + 1;
				}
			else {
				y = y + 1;
				}
		}
					
		// Fila Preferencial
		Agencia.texto1.setText(Integer.toString((Integer.parseInt(Agencia.texto1.getText())) + (x)));
		// Fila Normal
		Agencia.texto2.setText(Integer.toString((Integer.parseInt(Agencia.texto2.getText())) + (y)));
			}
			
		} catch (InterruptedException | NumberFormatException ex)  {
			
		}
		
	}
		
}
