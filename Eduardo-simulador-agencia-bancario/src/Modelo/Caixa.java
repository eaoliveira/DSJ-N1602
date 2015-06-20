package Modelo;

public class Caixa extends Thread {
	Fila primaria;
	Fila secundaria;
	public Cliente atendimento;

	public Caixa(Fila primaria, Fila secundaria) {
		this.primaria = primaria;
		this.secundaria = secundaria;
	}

	public void abre() {
		this.start();
	}

	public void fecha() {
		this.interrupt();
	}

	@Override
	public void run() {
		try {
			while (!this.interrupted()) {
				if (primaria.temGente()) {
					this.atendimento = this.primaria.proximo();
				} else if (secundaria.temGente()) {
					this.atendimento = this.secundaria.proximo();
				} else if (atendimento == null) {
					int docs = atendimento != null ? atendimento.getDocumento()
							: 5;

					Thread.sleep(docs * 1000);

				}

			}
		} catch (InterruptedException e) {
			System.out.println("Erro no caixa: "+e.toString());
		}
	}
}
