package Modelo;

import java.util.Random;

public class Cliente {
	int documento;
	boolean youIsOld;
	static Random rd;
	
	public Cliente() {
		rd = new Random();
		setDocumento(this.rd.nextInt(10));
		setYouIsOld( false);
	}
	
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}
	public boolean isYouIsOld() {
		return youIsOld;
	}
	public void setYouIsOld(boolean youIsOld) {
		this.youIsOld = youIsOld;
	}

	public boolean getTipo() {
		
		return this.youIsOld;
	}
	
}
