package objeto;

// POJO
public class Carro implements Comparable<Carro> {
	private int aro;
	private String cor;
	private int ano;
	private Banco bancos;

	public Carro() {
		ano = 2000;
		cor = "preto";
		aro = 13;
	}
	// Construtor
	public Carro(int ano, int aro, String cor) {
		setAno(ano);
		setAro(aro);
		setCor(cor);
	}

	public int getAro() {
		return aro;
	}

	public void setAro(int aro) {
		this.aro = aro;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Banco getBancos() {
		return bancos;
	}

	public void setBancos(Banco bancos) {
		this.bancos = bancos;
	}

	@Override
	public String toString() {
		return "aro:" + aro + " cor:" + cor + " ano:" + ano + " bancos:" + bancos;
	}

	@Override
	public int compareTo(Carro o) {
		int r =  -(ano - o.ano);
		if(r == 0)
			r = cor.compareTo(o.cor);
		return r;
	}


}
