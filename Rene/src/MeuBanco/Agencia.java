package MeuBanco;

public class Agencia extends Thread {
	FilaBancaria preferencial = new FilaBancaria();
	FilaBancaria normal = new FilaBancaria();
	private int qtdClintes = 10;
	Caixa[] caixas = { new Caixa(preferencial, normal),
			new Caixa(preferencial, normal), new Caixa(preferencial, normal),
			new Caixa(preferencial, normal), new Caixa(preferencial, normal) };

	public void abrir() {
		for (Caixa cx : caixas) {
			cx.abre();
			start();
		}
	}

	public void fechar() {
		interrupt();
		for (Caixa cx : caixas) {
			cx.fecha();
		}
	}

	public void run() {
		try {
			while (!isInterrupted()) {
				for (int i = 0; i < qtdClintes; i++) {
					Cliente cli = new Cliente();

					if (cli.getTipo()) {
						System.out.println("fdfdsf");
						preferencial.entrar(cli);
					} else {
						normal.entrar(cli);
					}
					Thread.sleep(5);
				}
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

	public int getQtdClintes() {
		return qtdClintes;
	}

	public void setQtdClintes(int qtdClintes) {
		this.qtdClintes = qtdClintes;
	}

}
