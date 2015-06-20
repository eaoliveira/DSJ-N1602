package Thread.FilaBancaria;

import java.util.Random;

public class Cliente {
	
	private boolean tipo;
	private int documento;
	
	public boolean isTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}
	private static Random rd = new Random(); 
	
	Cliente(){		
		tipo = rd.nextBoolean();
		documento = rd.nextInt();
		}

}
