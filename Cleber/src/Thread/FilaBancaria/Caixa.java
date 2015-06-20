package Thread.FilaBancaria;

public class Caixa extends Thread {
	
	FilaBancaria primaria;
	FilaBancaria secundaria;
	Cliente atendimento;
	
	Caixa(FilaBancaria pri, FilaBancaria sec){		
		pri = primaria;
		sec = secundaria;
		}
	public void abre(){
		start();
	}
	public void fecha(){
		interrupt();
	}
	
	public void run(){
		
		while(! isInterrupted()){
			
			if(primaria.temGente()){
				
				atendimento = primaria.proximo();
			}
			else if(secundaria.temGente()){
				
				atendimento = secundaria.proximo();
			}
			if (atendimento == null){}
			
		}
	}
	
	

}
