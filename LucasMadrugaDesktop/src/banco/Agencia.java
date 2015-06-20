package banco;

public class Agencia extends Thread {
	private int qtdeClientes = 10;
	private Fila filaNormal = new Fila();
	private Fila filaPreferencial = new Fila();
	private Caixa[] caixas = { new Caixa(filaPreferencial, filaPreferencial),
			new Caixa(filaPreferencial, filaPreferencial),
			new Caixa(filaNormal, filaPreferencial),
			new Caixa(filaNormal, filaPreferencial),
			new Caixa(filaNormal, filaPreferencial) };

	public Agencia() {

	}

	public void abrirAgencia() {
		for (Caixa cx : caixas) {
			cx.abrirCaixa();
			start();
		}
	}

	public void fecharAgencia() {
		interrupted();
		for (Caixa cx : caixas) {
			cx.fecharCaixa();

		}

	}

	public void run() {
		try {
			while(!isInterrupted()){
			for (int i = 0; i < qtdeClientes; i++) {
				Cliente cliente = new Cliente();
				if (cliente.isTipoCliente()) {
					filaPreferencial.entrar(cliente);
				} else {
					filaNormal.entrar(cliente);
				}
			}
			Thread.sleep(5);
		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
