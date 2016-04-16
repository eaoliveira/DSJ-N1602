package modelo;

public enum Horario {
	MANHA ("Manhã"),
	TARDE ("Tarde"),
	NOITE ("Noite");
	
	private String tipo;
	
	private Horario(String tipo) {
		this.tipo = tipo;
	}
	
	public String getNome() {
		return tipo;
	}
	
	@Override
	public String toString() {
		return tipo;
	}
}
