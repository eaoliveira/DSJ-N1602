package objeto.telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MinhaSegundaTela extends JFrame {

	private JPanel contentPane;
	private JLabel lbNome;
	private JTextField tfNome;
	private JButton btOk;
	private JButton btSair;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MinhaSegundaTela frame = new MinhaSegundaTela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MinhaSegundaTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 305, 138);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbNome());
		contentPane.add(getTfNome());
		contentPane.add(getBtOk());
		contentPane.add(getBtSair());
		getRootPane().setDefaultButton(getBtOk());
		setLocationRelativeTo(null);
	}

	private JLabel getLbNome() {
		if (lbNome == null) {
			lbNome = new JLabel("Nome");
			lbNome.setBounds(29, 22, 70, 15);
		}
		return lbNome;
	}

	private JTextField getTfNome() {
		if (tfNome == null) {
			tfNome = new JTextField();
			tfNome.setBounds(80, 20, 196, 19);
			tfNome.setColumns(10);
		}
		return tfNome;
	}

	private JButton getBtOk() {
		if (btOk == null) {
			btOk = new JButton("Ok");
			btOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, tfNome.getText());
					tfNome.setText("");
					tfNome.requestFocus();
				}
			});
			btOk.setBounds(24, 66, 117, 25);
		}
		return btOk;
	}
	private JButton getBtSair() {
		if (btSair == null) {
			btSair = new JButton("Sair");
			btSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btSair.setBounds(159, 66, 117, 25);
		}
		return btSair;
	}
}
