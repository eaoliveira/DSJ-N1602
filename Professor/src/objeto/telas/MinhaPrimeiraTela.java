package objeto.telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jpedal.examples.simpleviewer.utils.IconiseImage;

@SuppressWarnings("serial")
public class MinhaPrimeiraTela extends JFrame {
	private JTextField tfNome = new JTextField(10);
	private JButton btOk = new JButton("Ok");
	private JButton btSair = new JButton("Sair");

	public MinhaPrimeiraTela() {
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, tfNome.getText());
				tfNome.setText("");
				tfNome.requestFocus();
			}
		});

		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		Icon icone = new ImageIcon(
				MinhaPrimeiraTela.class.getResource("tri.gif")); 
		
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		p1.add(new JLabel(icone));
		p1.add(new JLabel("Nome"));
		p1.add(tfNome);
		add(p1, BorderLayout.CENTER);
		
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
		p2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		p2.add(btOk);
		p2.add(btSair);
		add(p2, BorderLayout.SOUTH);
		
		setResizable(false);
		pack();
		getRootPane().setDefaultButton(btOk);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MinhaPrimeiraTela tela = new MinhaPrimeiraTela();
		tela.setVisible(true);
	}
}
