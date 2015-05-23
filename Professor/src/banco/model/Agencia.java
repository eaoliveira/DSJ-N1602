package banco.model;

public class Agencia extends Thread {
	private FilaBancaria preferencial = new FilaBancaria();
	private FilaBancaria normal = new FilaBancaria();
	private int qtdCli = 10;
	private Caixa[] caixas = {
		new Caixa(preferencial, normal),
		new Caixa(preferencial, normal),
		new Caixa(normal, preferencial),
		new Caixa(normal, preferencial),
		new Caixa(normal, preferencial)
	};
	
	public FilaBancaria getPreferencial() {
		return preferencial;
	}

	public FilaBancaria getNormal() {
		return normal;
	}

	public Caixa[] getCaixas() {
		return caixas;
	}

	public void setQtdClientes(int num) {
		if(num > 10 || num < 0)
			qtdCli = 10;
		else
			qtdCli = num;
	}
	
	public void abrir() {
		for (Caixa cx : caixas)
			cx.abrir();
		
		start();
	}
	
	public void fechar() {
		interrupt();
		for (Caixa cx : caixas) 
			cx.interrupt();
	}
	
	public void run() {
		try { 
			while(!isInterrupted()) {
				for (int i = 0; i < qtdCli; i++) {
					Cliente cli = new Cliente();
					if(cli.getTipo().equals(TipoCliente.IDOSO))
						preferencial.entra(cli);
					else
						normal.entra(cli);
				}
				
				Thread.sleep(5);
			}
		} catch(InterruptedException ex) {
		}
	}
}
