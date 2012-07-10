package logica;

import java.util.Arrays;

public class TesteArrays {
	public static void main(String[] args) {
		int[] numeros = { 3,6,2,8,4,9,4,65,3,0};
		
		Arrays.sort(numeros);
		
		for (int i =  numeros.length -1;i >= 0; i--) {
			System.out.print(numeros[i] + " ");
		}
		System.out.println();
		
		// Declara e inicializa um array de 10 inteiros
		int[] lista = new int[10];
		
		// Preenche o array com o valor 10
		Arrays.fill(lista, 10);
		// Lista o conteudo do array
		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i] + " ");
		}
		System.out.println();

		// Obter o mecanismo de geração de numeros aleatorios
		// Preencher o array com numeros aleatorios
		for (int i = 0; i < lista.length; i++)
			lista[i]=(int)(Math.random() * 20);
		
		Arrays.sort(lista);	
				
		// Lista o conteudo do array
		for (int i = lista.length -1; i >= 0; i--) {
			System.out.print(lista[i] + " ");
		}
	}
}
