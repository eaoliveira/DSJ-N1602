package banco;

public class agencia extends Thread {

	fila filaidoso = new fila();
	fila filanormal = new fila();
	int qtdcliente = 10;
	caixa[] caixa = { new caixa(filaidoso, filanormal),
			new caixa(filaidoso, filanormal), new caixa(filaidoso, filanormal),
			new caixa(filaidoso, filanormal), new caixa(filaidoso, filanormal) };

	public void abrir() {
		for (caixa cx : caixa) {
			cx.abre();
			start();
		}
	}

	public void fecha() {
		interrupted();
		for (caixa cx : caixa) {
			cx.fecha();
		}
	}

	public void run() {
		try {
			while (!isInterrupted()) {
				for (int i = 0; i < qtdcliente; i++) {
					cliente c = new cliente();
					if (c.getTipocliente()) {
						filaidoso.entrar(c);
					} else {
						filanormal.entrar(c);
					}
				}
				Thread.sleep(5);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}