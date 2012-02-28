package objeto;


public class CadCarro {
 	public static void main(String[] args) {
		Carro a;
		a = new Carro();  // construtor padrão
		a.setAno(1995);
		a.setAro(15);
		a.setCor("branco");
		System.out.println(a);
		
		Carro b = new Carro();
		b.setAno(2012);
		b.setAro(14);
		
		Carro c = new Carro(2011, 14, "amarelo");
		System.out.println(b + "\n" + c);
	}
}
