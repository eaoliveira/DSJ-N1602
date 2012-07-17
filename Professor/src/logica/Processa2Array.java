package logica;

public class Processa2Array {
	public static void processa() throws  ArrayIndexOutOfBoundsException {
		int[][] lista = new int[4][3];
/*      j  j  j  
 i     [ ][ ][ ]
 i     [ ][ ][ ] 
 i     [ ][ ][ ] 
 i     [ ][ ][ ] 
 
 */
		
		
		for (int i = 0; i < lista.length; i++) {
			for (int j = 0; j < lista[i].length; j++) {
				lista[i][j] = 0;
			}
		}
	}
}
