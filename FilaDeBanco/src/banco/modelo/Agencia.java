package banco.modelo;

import java.util.Arrays;
import java.util.List;

public class Agencia extends Thread {
	private Integer pessoas = 10; // nº de pessoas a cada 5 segundos
	private FilaBancaria normal = new FilaBancaria();
	private FilaBancaria preferencial = new FilaBancaria();
	private final Caixa[] caixas = { 
			new Caixa(preferencial, normal), // caixa 1
			new Caixa(preferencial, normal), // caixa 2
			new Caixa(normal, preferencial), // caixa 3
			new Caixa(normal, preferencial), // caixa 4
			new Caixa(normal, preferencial) // caixa 5
	};

	public void abre() {
		this.start();
	}
	
	public void setPessoas(Integer num) {
		if(num <0) num = 0;
		else if(num > 10) num = 10;
		this.pessoas = num;
	}
	
	public Integer getPessoas() {
		return pessoas;
	}
	
	public List<Caixa> getCaixas() {
		return Arrays.asList(caixas);
	}
	
	public Integer quantosNaFilaNormal() {
		return normal.quantidade();
	}
	
	public Integer quantosNaFilaPrefencial() {
		return preferencial.quantidade();
	}
	
	public void run() {
		try {
			// Abre os caixas
			for (Caixa caixa : caixas)
				caixa.abre();

			 // pessoas chegam ao Banco a cada 5 seg
			while (true) {
				for (int i = 0; i < pessoas; i++) {
					// Determina aleatoriamente quais tipos de
					// clientes entram no Banco
					Cliente cli = new Cliente();

					if (cli.getTipoCliente().equals(TipoCliente.NORMAL))
						normal.entre(cli);
					else
						preferencial.entre(cli);
				}
				sleep(5000);
			}
		} catch (InterruptedException ex) {
		}
	}
}
