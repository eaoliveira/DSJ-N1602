package Modelo;

public class Agencia extends Thread {

	Fila preferencial;
	Fila normal;
	Caixa[] caixas;
	int qtdCli;
	public String estaAberta;
	

	public Agencia() {
		this.preferencial = new Fila();
		this.normal = new Fila();
		this.qtdCli = 10;
		this.estaAberta="";

		caixas = new Caixa[5];
		caixas[0] = new Caixa(preferencial, normal);
		caixas[1] = new Caixa(preferencial, normal);
		caixas[2] = new Caixa(preferencial, normal);
		caixas[3] = new Caixa(normal, preferencial);
		caixas[4] = new Caixa(normal, preferencial);
	}
	
	public Caixa[] getListaDeCaixa(){
		return this.caixas;
	}

	public void abrir() {
		for (Caixa cx : caixas) {
			cx.start();
		}
		start();
		this.estaAberta="Agencia Aberta";

	}

	public void fechar() {
		for (Caixa cx : caixas) {
			cx.interrupt();
		}
		this.estaAberta="Agencia Fechada";
	}

	@Override
	public void run() {
		try {
			while (!this.isInterrupted()) {
				for (int i = 0; i < this.qtdCli; i++) {

					Cliente cl = new Cliente();
					if (cl.getTipo()) {
						preferencial.entrar(cl);
					} else {
						normal.entrar(cl);
					}
				}
				this.sleep(5);
			}
		} catch (InterruptedException erro) {
			System.out.println("Erro: " + erro.toString());
		}
	}
}
