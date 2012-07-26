package objeto.exemplos;

public class CadDeEquipamentos {
	public static void main(String[] args) {
		Computador comp = new Computador();
		Disco d = new Disco();
		d.setMarca("Maxtor");
		d.setCapacidade(1000);
		d.setConector("eSATA");
		comp.setDisco(d);
		
		Memoria m = new Memoria();
		m.setMarca("Samsung");
		m.setCapacidade(16);
		m.setSoquete("DDR3");
		comp.setMemoria(m);
		
		Processador p = new Processador();
		p.setMarca("AMD");
		p.setTipo("BullDozer");
		p.setNucleos(12);
		comp.setProcessador(p);
	}
}
