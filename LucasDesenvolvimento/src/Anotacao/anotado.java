package Anotacao;

public class anotado {
	public static void main(String [] args) {
		Afazer afazer = exercicio01.class.getAnnotation(Afazer.class);
		System.out.printf(afazer.descricao());
		System.out.printf(afazer.data());
	}
	
}
