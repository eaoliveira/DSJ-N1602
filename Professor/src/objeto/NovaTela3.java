package objeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class NovaTela3 extends JFrame {
	private JPanel contentPane;
	private JPanel panel;
	private JButton btOk;
	private JButton btSair;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNome;
	private JTextField tfNome;
	private JLabel lblIdade;
	private JTextField tfIdade;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovaTela3 frame = new NovaTela3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NovaTela3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.SOUTH);
		contentPane.add(getPanel_1(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtOk());
			panel.add(getBtSair());
		}
		return panel;
	}

	private JButton getBtOk() {
		if (btOk == null) {
			btOk = new JButton("Ok");
			btOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btOk;
	}

	private JButton getBtSair() {
		if (btSair == null) {
			btSair = new JButton("Sair");
			btSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btSair;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(0, 1, 0, 0));
			panel_1.add(getPanel_3());
			panel_1.add(getPanel_2());
		}
		return panel_1;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panel_2.add(getLblIdade());
			panel_2.add(getTfIdade());
		}
		return panel_2;
	}

	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panel_3.add(getLblNome());
			panel_3.add(getTfNome());
		}
		return panel_3;
	}

	private JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel("Nome");
		}
		return lblNome;
	}

	private JTextField getTfNome() {
		if (tfNome == null) {
			tfNome = new JTextField();
			tfNome.setColumns(10);
		}
		return tfNome;
	}

	private JLabel getLblIdade() {
		if (lblIdade == null) {
			lblIdade = new JLabel("Idade");
		}
		return lblIdade;
	}

	private JTextField getTfIdade() {
		if (tfIdade == null) {
			tfIdade = new JTextField();
			tfIdade.setColumns(5);
		}
		return tfIdade;
	}
}
