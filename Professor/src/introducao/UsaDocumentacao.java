package introducao;

import javax.swing.JOptionPane;

public class UsaDocumentacao {
	public static void main(String[] args) {
		String texto1 = JOptionPane.showInputDialog("Informe um texto");
		String texto2 = JOptionPane.showInputDialog("Informe um texto");
		Documentacao2 dc1 = new Documentacao2(texto1);
		Documentacao2 dc2 = new Documentacao2(texto2);

		JOptionPane.showMessageDialog(null, dc1.inverso()+"\n"+ dc2.inverso());
	}
}
