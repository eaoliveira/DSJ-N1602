package logica.resposta;

public class Ex06 {
	public static void main(String[] args) {
		int[][] num = new int[10][20];
		
		for (int i = 0; i < num.length; i++) 
			for (int j = 0; j < num[i].length; j++) 
				num[i][j] = i * j;
			
		for (int i = num.length -1; i >= 0; i--) {
			for (int j = num[i].length-1; j >= 0; j--) {
				System.out.format("%03d ", num[i][j]);
			}
			System.out.println();
		}
		
		
	}
}
