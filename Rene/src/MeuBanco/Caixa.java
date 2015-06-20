package MeuBanco;

public class Caixa extends Thread {
	FilaBancaria primaria;
	FilaBancaria secundaria;
	Cliente atendimento;
	
	Caixa(FilaBancaria pri, FilaBancaria sec) {
		primaria = pri;
		secundaria = sec;
	}
	
	public void abre(){
		start();
	}
	public void fecha(){
		interrupt();
	}
	public void run() {
		while(!isInterrupted()){
			if(primaria.temGente()){
				atendimento = primaria.proximo();
			}else if(secundaria.temGente()){
				atendimento = secundaria.proximo();
			}else{
				atendimento = null;
			}
		}
		int docs = atendimento != null?
			atendimento.getDocumentos() : 5;
			try {
				Thread.sleep(docs * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
