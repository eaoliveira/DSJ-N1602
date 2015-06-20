package banco;

import java.util.Random;

public class cliente {
	
	private Boolean tipocliente;
	private int documento;
	private static Random rd = new Random();
	public cliente(){
		documento = rd.nextInt(15);
		tipocliente = rd.nextBoolean();
				
	}

	public Boolean getTipocliente() {
		return tipocliente;
	}

	public void setTipocliente(Boolean tipocliente) {
		this.tipocliente = tipocliente;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}
	
	@Override
	public String toString() {
		return "cliente [tipocliente=" + tipocliente + ", documento="
				+ documento + "]";
	}
	

}
