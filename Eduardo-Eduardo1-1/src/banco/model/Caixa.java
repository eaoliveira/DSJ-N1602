package banco.model;

public class Caixa extends Thread {
	private FilaBancaria primaria;
	private FilaBancaria secundaria;
	private Cliente atendimento;
	
	public Caixa(FilaBancaria primaria, FilaBancaria secundaria) {
		this.primaria = primaria;
		this.secundaria = secundaria;
	}
	
	public void abrir() {
		start();
	}
	
	public void fechar() {
		interrupt();
	}
	
	public FilaBancaria getPrimaria() {
		return primaria;
	}

	public FilaBancaria getSecundaria() {
		return secundaria;
	}

	public TipoCliente getAtendimento() {
		return atendimento != null ? atendimento.getTipo() : TipoCliente.NENHUM;
	}
	
	public void run() {
		try {
			while(!isInterrupted()) {
				if(primaria.quantos() > 0)
					atendimento = primaria.proximo();
				else if(secundaria.quantos() > 0)
					atendimento = secundaria.proximo();
					
				int docs = atendimento != null ? atendimento.getDocumentos() : 5;
				
				Thread.sleep(docs * 1000);
			}
		} catch (InterruptedException ex) {
			System.err.println("Caixa Fechado");
		}
	}
}
