package banco.model;

public class Agencia extends Thread {
	private FilaBancaria preferencial = new FilaBancaria();
	private FilaBancaria normal = new FilaBancaria();
	private int qtdCli = 10;
	private Caixa[] caixas = { new Caixa(preferencial, normal),
			new Caixa(preferencial, normal), new Caixa(normal, preferencial),
			new Caixa(normal, preferencial), new Caixa(normal, preferencial) };

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
		if (num > 10 || num < 0)
			qtdCli = 10;
		else
			qtdCli = num;
	}

	public void abrir() {
		for (Caixa cx : caixas)
			cx.abrir();

		start();
	}

	public Thread fechar() {
		interrupt();
		// Implementação para tratar todos os clientes após o fechamento da agência
		Thread t = new Thread(() -> {
			try {
				while (preferencial.quantos() > 0 || normal.quantos() > 0) {
					Thread.sleep(5000);
				}
				for (Caixa cx : caixas)
					cx.interrupt();
			} catch (InterruptedException ex) {
			}
		});
		t.start();
		return t;
	}

	public void run() {
		try {
			while (!isInterrupted()) {
				for (int i = 0; i < qtdCli; i++) {
					Cliente cli = new Cliente();
					if (cli.getTipo().equals(TipoCliente.IDOSO))
						preferencial.entra(cli);
					else
						normal.entra(cli);
				}

				Thread.sleep(5000); // ajuste do tempo de entrada de clientes na agência
			}
		} catch (InterruptedException ex) {
		}
	}
}
