package banco.modelo;

public class Caixa extends Thread {
	private FilaBancaria filaPrimaria;
	private FilaBancaria filaSecundaria;
	private Boolean aberto;
	private Integer numero;
	private Cliente atendimento;

	public Caixa(FilaBancaria filaPrimaria,	FilaBancaria filaSecundaria) {
		this.filaPrimaria = filaPrimaria;
		this.filaSecundaria = filaSecundaria;
		this.aberto = false;
	}

	public TipoCliente getAtendimento() {
		if(atendimento != null)
		  return atendimento.getTipoCliente();
		else
			return TipoCliente.NENHUM;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void abre() {
		aberto = true;
		this.start();
	}

	public void fecha() {
		aberto = false;
	}

	public void run() {
		try {
			while (aberto) {
				if (!filaPrimaria.estaVazia())
						atendimento = filaPrimaria.proximo();
				else if (!filaSecundaria.estaVazia())
						atendimento = filaSecundaria.proximo();
				
				if(atendimento == null)
					sleep(2000); // espere 2 seg;
				else
					sleep(atendimento.getDocumentos()*1000); // 1 seg por documento
				
				atendimento = null;
			}
		} catch (InterruptedException ex) {
		}
	}
}
