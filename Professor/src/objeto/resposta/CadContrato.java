package objeto.resposta;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;


@SuppressWarnings("serial")
public class CadContrato extends JFrame {

	private JPanel contentPane;
	private JLabel lblN;
	private JTextField tfNum;
	private JLabel lblAno;
	private JTextField tfAno;
	private JLabel lblDescr;
	private JTextField tfDescr;
	private JButton btInserir;
	private JButton btListar;
	private JButton btSair;
	private List<Contrato> lista = new ArrayList<>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadContrato frame = new CadContrato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadContrato() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_contentPane
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_contentPane
												.createParallelGroup(Alignment.LEADING, false)
												.addGroup(
														gl_contentPane
																.createSequentialGroup()
																.addComponent(getLblN())
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(getTfNum(),
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(29)
																.addComponent(getLblAno())
																.addGap(26)
																.addComponent(getTfAno(),
																		GroupLayout.PREFERRED_SIZE, 91,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_contentPane.createSequentialGroup()
																.addComponent(getLblDescr())
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(getTfDescr())))
								.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(
						Alignment.TRAILING,
						gl_contentPane.createSequentialGroup()
								.addContainerGap(55, Short.MAX_VALUE)
								.addComponent(getBtInserir()).addGap(18)
								.addComponent(getBtListar()).addGap(18)
								.addComponent(getBtSair()).addGap(44)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addComponent(getLblN())
										.addGroup(
												gl_contentPane
														.createParallelGroup(Alignment.TRAILING)
														.addGroup(
																gl_contentPane
																		.createParallelGroup(Alignment.BASELINE)
																		.addComponent(getLblAno())
																		.addComponent(getTfAno(),
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(getTfNum(),
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)))
						.addGap(18)
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addComponent(getLblDescr())
										.addComponent(getTfDescr(), GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(getBtInserir(), Alignment.TRAILING)
										.addComponent(getBtListar(), Alignment.TRAILING)
										.addComponent(getBtSair(), Alignment.TRAILING))
						.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}

	private JLabel getLblN() {
		if (lblN == null) {
			lblN = new JLabel("N.");
		}
		return lblN;
	}

	private JTextField getTfNum() {
		if (tfNum == null) {
			try {
				MaskFormatter mascara = new MaskFormatter("####");
				tfNum = new JFormattedTextField(mascara);
			} catch (ParseException ex) {
				tfNum = new JTextField();
			}
			tfNum.setColumns(10);
		}
		return tfNum;
	}

	private JLabel getLblAno() {
		if (lblAno == null) {
			lblAno = new JLabel("Ano");
		}
		return lblAno;
	}

	private JTextField getTfAno() {
		if (tfAno == null) {
			
			// Cria uma mascara de edicao para o campo Ano
			try {
				MaskFormatter mascara = new MaskFormatter("####");
				tfAno = new JFormattedTextField(mascara);
			} catch (ParseException ex) {
				// caso haja falha na criacao da mascara, eh criado um JTextFiel normal
				tfAno = new JTextField();
			}
			tfAno.setColumns(10);
		}
		return tfAno;
	}

	private JLabel getLblDescr() {
		if (lblDescr == null) {
			lblDescr = new JLabel("Descr.");
		}
		return lblDescr;
	}

	private JTextField getTfDescr() {
		if (tfDescr == null) {
			tfDescr = new JTextField();
			tfDescr.setColumns(10);
		}
		return tfDescr;
	}

	private JButton getBtInserir() {
		if (btInserir == null) {
			btInserir = new JButton("Inserir");
			btInserir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Contrato con = new Contrato();
					con.setNumero(Integer.parseInt(tfNum.getText()));
					con.setAno(Integer.parseInt(tfAno.getText()));
					con.setDescricao(tfDescr.getText());

					lista.add(con);

					tfNum.setText("");
					tfNum.requestFocus();
					tfAno.setText("");
					tfDescr.setText("");
				}
			});
		}
		return btInserir;
	}

	private JButton getBtListar() {
		if (btListar == null) {
			btListar = new JButton("Listar");
			btListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StringBuilder txt = new StringBuilder("Cad de Contratos\n\n");
					for (Contrato con : lista)
						txt.append(con + "\n");

					JOptionPane.showMessageDialog(null, txt);
				}
			});
		}
		return btListar;
	}

	private JButton getBtSair() {
		if (btSair == null) {
			btSair = new JButton("Sair");
			btSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return btSair;
	}
}
