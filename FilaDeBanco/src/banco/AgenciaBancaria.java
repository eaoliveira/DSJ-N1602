package banco;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import banco.modelo.Agencia;
import banco.modelo.Caixa;

@SuppressWarnings("serial")
public class AgenciaBancaria extends JFrame implements Runnable {
	private JPanel contentPane;
	private JLabel lblAgenciaBancria;
	private JLabel lblFilaPref;
	private JLabel lblFilaNormal;
	private JTextField tfNormal;
	private JTextField tfPref;
	private JLabel lblCaixas;
	private JTextField tfCaixa2;
	private JTextField tfCaixa1;
	private JTextField tfCaixa3;
	private JTextField tfCaixa4;
	private JTextField tfCaixa5;
	private JButton btIniciar;
	private JButton btFechar;
	private Agencia agencia;
	private final AgenciaBancaria instancia = this;
	private JLabel lblPessoasP;
	private JSpinner spinner;
	private JButton btnSalvar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgenciaBancaria frame = new AgenciaBancaria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AgenciaBancaria() {
		setTitle("Banco 1/2 Boca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						gl_contentPane.createSequentialGroup()
								.addContainerGap(54, Short.MAX_VALUE)
								.addComponent(getLblAgenciaBancria()).addGap(44))
				.addGroup(
						gl_contentPane
								.createSequentialGroup()
								.addGap(26)
								.addGroup(
										gl_contentPane
												.createParallelGroup(Alignment.LEADING)
												.addComponent(getLblFilaPref())
												.addComponent(getTfPref(), GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										gl_contentPane
												.createParallelGroup(Alignment.TRAILING)
												.addGroup(
														gl_contentPane
																.createSequentialGroup()
																.addGap(12)
																.addComponent(getSpinner(),
																		GroupLayout.PREFERRED_SIZE, 41,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(getBtnSalvar())
																.addPreferredGap(ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(getTfNormal(),
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_contentPane
																.createSequentialGroup()
																.addComponent(getLblPessoasP())
																.addPreferredGap(ComponentPlacement.RELATED,
																		42, Short.MAX_VALUE)
																.addComponent(getLblFilaNormal())))
								.addContainerGap())
				.addGroup(
						gl_contentPane.createSequentialGroup()
								.addContainerGap(195, Short.MAX_VALUE)
								.addComponent(getLblCaixas()).addGap(185))
				.addGroup(
						gl_contentPane
								.createSequentialGroup()
								.addContainerGap(56, Short.MAX_VALUE)
								.addGroup(
										gl_contentPane
												.createParallelGroup(Alignment.LEADING, false)
												.addGroup(
														gl_contentPane
																.createSequentialGroup()
																.addComponent(getBtIniciar())
																.addPreferredGap(ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(getBtFechar()))
												.addGroup(
														gl_contentPane
																.createSequentialGroup()
																.addComponent(getTfCaixa1(),
																		GroupLayout.PREFERRED_SIZE, 59,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(getTfCaixa2(),
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(getTfCaixa3(),
																		GroupLayout.PREFERRED_SIZE, 59,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(getTfCaixa4(),
																		GroupLayout.PREFERRED_SIZE, 59,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(getTfCaixa5(),
																		GroupLayout.PREFERRED_SIZE, 59,
																		GroupLayout.PREFERRED_SIZE))).addGap(45)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLblAgenciaBancria())
						.addGap(18)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(getLblFilaPref())
										.addComponent(getLblFilaNormal())
										.addComponent(getLblPessoasP()))
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addGroup(
												gl_contentPane
														.createSequentialGroup()
														.addGap(18)
														.addGroup(
																gl_contentPane
																		.createParallelGroup(Alignment.BASELINE)
																		.addComponent(getTfNormal(),
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(getTfPref(),
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)))
										.addGroup(
												gl_contentPane
														.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(
																gl_contentPane
																		.createParallelGroup(Alignment.BASELINE)
																		.addComponent(getSpinner(),
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(getBtnSalvar()))))
						.addGap(28)
						.addComponent(getLblCaixas())
						.addGap(18)
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addComponent(getTfCaixa5(), Alignment.TRAILING,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(getTfCaixa1(), Alignment.TRAILING,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(getTfCaixa2(), Alignment.TRAILING,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(getTfCaixa3(), Alignment.TRAILING,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(getTfCaixa4(), Alignment.TRAILING,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(getBtIniciar()).addComponent(getBtFechar()))
						.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}

	private JLabel getLblAgenciaBancria() {
		if (lblAgenciaBancria == null) {
			lblAgenciaBancria = new JLabel("Agencia Bancária - Simulação de Filas");
			lblAgenciaBancria.setFont(new Font("Dialog", Font.BOLD, 16));
		}
		return lblAgenciaBancria;
	}

	private JLabel getLblFilaPref() {
		if (lblFilaPref == null) {
			lblFilaPref = new JLabel("Fila Preferencial");
		}
		return lblFilaPref;
	}

	private JLabel getLblFilaNormal() {
		if (lblFilaNormal == null) {
			lblFilaNormal = new JLabel("Fila Normal");
		}
		return lblFilaNormal;
	}

	private JTextField getTfNormal() {
		if (tfNormal == null) {
			tfNormal = new JTextField();
			tfNormal.setBackground(Color.CYAN);
			tfNormal.setEditable(false);
			tfNormal.setColumns(10);
		}
		return tfNormal;
	}

	private JTextField getTfPref() {
		if (tfPref == null) {
			tfPref = new JTextField();
			tfPref.setBackground(Color.PINK);
			tfPref.setEditable(false);
			tfPref.setColumns(10);
		}
		return tfPref;
	}

	private JLabel getLblCaixas() {
		if (lblCaixas == null) {
			lblCaixas = new JLabel("Caixas");
		}
		return lblCaixas;
	}

	private JTextField getTfCaixa2() {
		if (tfCaixa2 == null) {
			tfCaixa2 = new JTextField();
			tfCaixa2.setBackground(Color.PINK);
			tfCaixa2.setEditable(false);
			tfCaixa2.setColumns(5);
		}
		return tfCaixa2;
	}

	private JTextField getTfCaixa1() {
		if (tfCaixa1 == null) {
			tfCaixa1 = new JTextField();
			tfCaixa1.setBackground(Color.PINK);
			tfCaixa1.setEditable(false);
			tfCaixa1.setColumns(5);
		}
		return tfCaixa1;
	}

	private JTextField getTfCaixa3() {
		if (tfCaixa3 == null) {
			tfCaixa3 = new JTextField();
			tfCaixa3.setBackground(Color.CYAN);
			tfCaixa3.setEditable(false);
			tfCaixa3.setColumns(5);
		}
		return tfCaixa3;
	}

	private JTextField getTfCaixa4() {
		if (tfCaixa4 == null) {
			tfCaixa4 = new JTextField();
			tfCaixa4.setBackground(Color.CYAN);
			tfCaixa4.setEditable(false);
			tfCaixa4.setColumns(5);
		}
		return tfCaixa4;
	}

	private JTextField getTfCaixa5() {
		if (tfCaixa5 == null) {
			tfCaixa5 = new JTextField();
			tfCaixa5.setBackground(Color.CYAN);
			tfCaixa5.setEditable(false);
			tfCaixa5.setColumns(5);
		}
		return tfCaixa5;
	}

	private JButton getBtIniciar() {
		if (btIniciar == null) {
			btIniciar = new JButton("Abre a Agência");
			btIniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					agencia = new Agencia();
					// abre a agencia e os caixas
					agencia.abre();
					// inicia a atualização na tela
					new Thread(instancia).start();
					getSpinner().setValue(agencia.getPessoas());
					getSpinner().setEnabled(true);
					getBtnSalvar().setEnabled(true);
				}
			});
		}
		return btIniciar;
	}

	private JButton getBtFechar() {
		if (btFechar == null) {
			btFechar = new JButton("Fecha a Agência");
			btFechar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return btFechar;
	}

	private JLabel getLblPessoasP() {
		if (lblPessoasP == null) {
			lblPessoasP = new JLabel("Nº Pessoas p/ 5 seg");
		}
		return lblPessoasP;
	}

	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setValue(10);
			spinner.setEnabled(false);
		}
			return spinner;
	}

	private JButton getBtnSalvar() {
		if (btnSalvar == null) {
			btnSalvar = new JButton("Salvar");
			btnSalvar.setEnabled(false);
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					agencia.setPessoas((Integer)getSpinner().getValue());
					getSpinner().setValue(agencia.getPessoas());
				}
			});
		}
		return btnSalvar;
	}

	public void run() {
		JTextField[] fields = { tfCaixa1, tfCaixa2, tfCaixa3, tfCaixa4, tfCaixa5 };

		// Atualiza a tela a cada 1 seg
		try {
			while (true) {
				if (agencia != null) {
					tfNormal.setText(String.valueOf(agencia.quantosNaFilaNormal()));
					tfPref.setText(String.valueOf(agencia.quantosNaFilaPrefencial()));

					List<Caixa> caixas = agencia.getCaixas();
					for (int i = 0; i < fields.length; i++)
						fields[i].setText(caixas.get(i).getAtendimento().toString());

				}
				Thread.sleep(1000);
			}
		} catch (InterruptedException ex) {
		}
	}
}
