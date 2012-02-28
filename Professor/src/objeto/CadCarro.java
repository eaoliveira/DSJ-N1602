package objeto;


public class CadCarro {
 	public static void main(String[] args) {
		Carro[] garage = new Carro[3];
		
	  Carro a = new Carro();  // construtor padrão
		a.setAno(1995);
		a.setAro(15);
		a.setCor("branco");
		garage[0] = a;
		
		garage[1] = new Carro();
		garage[1] .setAno(2012);
		garage[1] .setAro(14);
		
		garage[2] = new Carro(2011, 14, "amarelo");
		
		for (int i = 0; i < garage.length; i++) {
			System.out.println(garage[i]);
		}
	}
}
