package objeto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NovaTela extends JFrame {
	NovaTela minhaReferencia = null;
	JTextField tfNome = new JTextField(10);
	JTextField tfIdade = new JTextField(5);

	public NovaTela() {
		// salvar a referencia da janela para uso posterior
		minhaReferencia = this;
		tfIdade.setText("0");
		
		setTitle("Nova Tela");
		// Configurar um tamanho para a janela
		// setPreferredSize(new Dimension(200, 200));
		setMinimumSize(new Dimension(200, 130));

		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p1.add(new JLabel("Nome"));
		p1.add(tfNome);

		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p2.add(new JLabel("Idade"));
		p2.add(tfIdade);

		add(p1, "North");
		add(p2, "Center");

		JPanel pnBotoes = new JPanel();
		JButton btOk = new JButton("Ok");
		btOk.setMnemonic(KeyEvent.VK_O);
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tfNome.getText();
				int idade = Integer.parseInt(tfIdade.getText());
				JOptionPane.showMessageDialog(minhaReferencia, 
						"Bem Vindo "  + nome + "\nSua idade é " + idade);
				tfNome.setText("");
				tfIdade.setText("0");
				tfNome.requestFocus();
			}
		});
		pnBotoes.add(btOk);
		JButton btSair = new JButton("Sair");
		btSair.setMnemonic(KeyEvent.VK_S);
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		pnBotoes.add(btSair);
		add(pnBotoes, BorderLayout.SOUTH);

		// Define o btOk como o botao default para a tela
		getRootPane().setDefaultButton(btOk);

		// reorganizar a janela e seu conteudo
		pack();
		// centralizar a janela na tela
		setLocationRelativeTo(null);
		// configura a janela para finalizar a VM Java
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		NovaTela n = new NovaTela();
		n.setVisible(true);
	}


}
