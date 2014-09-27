import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class PainelDeMensagem {

	public static void main(String[] args) {
		PainelDeMensagem.showMessageDialog(null, 
				"Teste de execução de programa contendo janela\n" +
				"para apresentação de dados oriundos de processamento" +
				" do cadastro de contratação de valores para investidores\n" +
				"da bolda da amazônia no período contante de documentação" +
				" registrada em cartório da comarca de Alcantara \n" +
				"Machado dos Santos no Município de Juazeiro do Sul" +
				" em Santa Caratina do Norte em Rio Grande do Norte\n" +
				"no Nordeste do Estado da Bahia", "Mensagem");
	}
	
	public static void showMessageDialog(Component parente, String mensagen, String titulo) {
		JDialog dialogo = new JDialog();
		dialogo.setModal(true);
		dialogo.setTitle(titulo);
		dialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JPanel pntexto = new JPanel();
		pntexto.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		JTextArea texto = new JTextArea("");
		texto.setBackground(UIManager.getColor("Button.background"));
		texto.setEditable(false);
		texto.setText(mensagen);
		pntexto.add(texto);
		dialogo.add(pntexto, BorderLayout.CENTER);
		
		JPanel botoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 5));
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(e -> dialogo.dispose());
		botoes.add(btnOk);
		
		JButton btnCalcela = new JButton("Calcela");
		btnCalcela.addActionListener(e -> dialogo.dispose());
		botoes.add(btnCalcela);
		dialogo.add(botoes, BorderLayout.SOUTH);
		
		dialogo.getRootPane().setDefaultButton(btnOk);
		dialogo.pack();
		dialogo.setLocationRelativeTo(parente);
		dialogo.setResizable(false);
		dialogo.setVisible(true);
	}
}
