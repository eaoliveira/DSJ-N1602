package logica;


public class ExVetor {
	public static void main(String[] args) {
		
	  int[] num = new int[3];  
	  num[0] = 3;
	  num[1] = 4 ;
	  num[2] = 5;
	  printInt(num);
	  printInt(new int[] {3,2,1});
	  printInt(3,2,1);
	  printInt();
	}

	public static void printInt(int... lista) {
//		for (int i = 0; i < lista.length; i++) {
//			int numero = lista[i];
		for(int numero : lista) {	
			System.out.println(numero);
		}
	}
}
