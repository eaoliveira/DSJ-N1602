package objeto;

public class Utilitario extends Carro {
	private double capacidade;

	public double getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(double capacidade) {
		this.capacidade = capacidade;
	}

	@Override
	public String toString() {
		return super.toString() + " Capacidade:" + capacidade;
	}
	
}
