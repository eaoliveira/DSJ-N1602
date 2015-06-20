package banco;

public class Caixa extends Thread {
	private FilaBancaria filaPrimaria, filaSecundaria;
	private Clientes atendimento;
	
	public Caixa(FilaBancaria filaPrimaria, FilaBancaria filaSecundaria) {
		super();
		this.filaPrimaria = filaPrimaria;
		this.filaSecundaria = filaSecundaria;
	}
	
	public void abrirCaixa() {
		this.start();
	}
	
	public void fecharCaixa() {
		this.interrupt();
	}
	
	public void run() {
		
		while(!isInterrupted()) {
			try {
				if(filaPrimaria.temGente()) {
					atendimento = filaPrimaria.proximo();
				} else if(filaSecundaria.temGente()) {
					atendimento = filaSecundaria.proximo();
				} else {
					atendimento = null;
				}
				
				int docs = atendimento != null ? atendimento.getDocumentos() : 5;
				
				Thread.sleep(docs*1000);
				
			} catch(InterruptedException ex) {
				ex.getMessage();
				ex.printStackTrace();
			}
		}
		
	}


}
