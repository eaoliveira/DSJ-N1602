package banco;

public class Agencia extends Thread {
	private int nClientes;
	private FilaBancaria preferencial = new FilaBancaria();
	private FilaBancaria normal = new FilaBancaria();
	private Caixa[] caixas = { new Caixa(preferencial, normal),
			new Caixa(preferencial, normal), new Caixa(normal, preferencial),
			new Caixa(normal, preferencial), new Caixa(normal, preferencial) };

	public int getnClientes() {
		return nClientes;
	}

	public void setnClientes(int nClientes) {
		this.nClientes = nClientes;
	}

	public void abrir() {
		for (Caixa i : caixas) {
			i.abrirCaixa();
			this.start();
		}
	}

	public void fechar() {
		this.interrupt();
		for (Caixa i : caixas) {
			i.fecharCaixa();
		}
	}

	public void run() {

		try {

			while (!isInterrupted()) {
				for (int i = 0; i < nClientes; i++) {

					Clientes cliente = new Clientes();
					if (!cliente.isClienteNormal()) {
						preferencial.entrar(cliente);
					} else {
						normal.entrar(cliente);
						;
					}

				}

				Thread.sleep(5);
			}

		} catch (InterruptedException ex) {
			ex.getMessage();
			ex.printStackTrace();
		}

	}

}
