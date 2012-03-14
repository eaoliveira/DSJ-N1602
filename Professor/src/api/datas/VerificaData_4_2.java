package api.datas;

import static api.gui.Util.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Crie um programa que verifique se a data digitada pelo usuário é válida ou
 * não. Verifique a data ono formato DD/MM/AA.
 * Sugestão de Tela:
 * 
 * 
 */

@SuppressWarnings("serial")
public class VerificaData_4_2 extends JFrame implements ActionListener {
	private JFormattedTextField tfData = criaMascara("##/##/##");
	private JButton btVerifica = criaBotao("Verifica", KeyEvent.VK_F, this);
	private JButton btSair = criaBotao("Sair", KeyEvent.VK_S, this);

	public VerificaData_4_2() {
		setTitle("Verifica Datas");

		add(criaPainel("Informe uma Data", tfData), BorderLayout.CENTER);
		add(criaPainel(btVerifica, btSair), BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getRootPane().setDefaultButton(btVerifica);
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() == btVerifica) {
			// Define o tipo de formato para
			// validar a data a ser informada
			// pelo usuário
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
			sdf.setLenient(false);

			// Fica dentro do loop enquando a data
			// informada seja inválida
			try {
				// Valida a data
				sdf.parse(tfData.getText());

				// Data OK
				JOptionPane.showMessageDialog(null, "Data válida");

				// Limpa o campo Data
				tfData.setValue(null);

				// Mostra mensagem, pois a data é inválida
			} catch(ParseException ex) {
				JOptionPane.showMessageDialog(null, "Data inválida!");
			}

			// Posiciona o cursor no campo Data
			tfData.requestFocus();
		} else {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new VerificaData_4_2();
	}
}
