import javax.swing.JOptionPane;

public class TesteJava {
	public static void main(String[] args) {
		String temp = 
				JOptionPane.showInputDialog("Informe um Nº");
		int num = Integer.parseInt(temp);
		JOptionPane.showMessageDialog(null,"O  nº é " +
				(num  + 10));
	}
}
