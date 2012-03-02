package objeto;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MinhaTela extends JFrame {
	public static void main(String[] args) {
		new MinhaTela();
	}
	
	public MinhaTela() {
		setTitle("Minha 1a. Tela");
		setPreferredSize(new Dimension(300, 200));
		JPanel pnBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JButton bt = new JButton("Me Aperta!");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "HAAAAAAAAAAA!");
			}
		});
		
		JButton bt2 = new JButton("Sai Fora!");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Sai Você!");
			}
		});
		
		pnBotoes.add(bt);
		pnBotoes.add(bt2);
		add(pnBotoes, "South");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
