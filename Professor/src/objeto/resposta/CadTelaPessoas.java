package objeto.resposta;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import objeto.respostas.Endereco;
import objeto.respostas.Pessoa;
import objeto.respostas.PessoaFisica;
import objeto.respostas.PessoaJuridica;

@SuppressWarnings("serial")
public class CadTelaPessoas extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNome;
	private JTextField tfNome;
	private JLabel lblFone;
	private JTextField tfFone;
	private JLabel lblRg;
	private JTextField tfRg;
	private JLabel lblCpf;
	private JTextField tfCpf;
	private JLabel lblEmail;
	private JTextField tfEmail;
	private JLabel lblCnpj;
	private JTextField tfCnpj;
	private JLabel lblIncrEst;
	private JTextField tfIe;
	private JLabel lblSite;
	private JTextField tfSite;
	private JButton btInserir;
	private JButton btListar;
	private JButton btSair;
	private List<Pessoa> lista = new ArrayList<>();
	private Endereco end;
	private JLabel lblEnd;
	private JButton btEnd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadTelaPessoas frame = new CadTelaPessoas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadTelaPessoas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(21)
								.addComponent(getTabbedPane(), GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(getLblNome())
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getTfNome())))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(getLblFone())
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getTfFone(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
							.addComponent(getLblEnd())
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getBtEnd())))
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(100, Short.MAX_VALUE)
					.addComponent(getBtInserir())
					.addGap(18)
					.addComponent(getBtListar())
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(getBtSair())
					.addGap(89))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(getLblNome())
						.addComponent(getTfNome(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(getLblFone())
						.addComponent(getTfFone(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(getLblEnd())
						.addComponent(getBtEnd()))
					.addGap(14)
					.addComponent(getTabbedPane(), GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(getBtInserir(), Alignment.TRAILING)
						.addComponent(getBtListar(), Alignment.TRAILING)
						.addComponent(getBtSair(), Alignment.TRAILING))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("Fisica", null, getPanel(), null);
			tabbedPane.addTab("Juridica", null, getPanel_1(), null);
		}
		return tabbedPane;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
					Alignment.LEADING).addGroup(
					gl_panel
							.createSequentialGroup()
							.addContainerGap()
							.addGroup(
									gl_panel
											.createParallelGroup(Alignment.LEADING)
											.addGroup(
													gl_panel
															.createSequentialGroup()
															.addComponent(getLblRg())
															.addPreferredGap(ComponentPlacement.RELATED)
															.addComponent(getTfRg(),
																	GroupLayout.PREFERRED_SIZE, 252,
																	GroupLayout.PREFERRED_SIZE))
											.addGroup(
													gl_panel
															.createSequentialGroup()
															.addComponent(getLblCpf())
															.addPreferredGap(ComponentPlacement.UNRELATED)
															.addComponent(getTfCpf(),
																	GroupLayout.PREFERRED_SIZE, 255,
																	GroupLayout.PREFERRED_SIZE))
											.addGroup(
													gl_panel
															.createSequentialGroup()
															.addComponent(getLblEmail())
															.addPreferredGap(ComponentPlacement.UNRELATED)
															.addComponent(getTfEmail(),
																	GroupLayout.PREFERRED_SIZE, 254,
																	GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(59, Short.MAX_VALUE)));
			gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(
							gl_panel
									.createSequentialGroup()
									.addContainerGap()
									.addGroup(
											gl_panel
													.createParallelGroup(Alignment.BASELINE)
													.addComponent(getLblRg())
													.addComponent(getTfRg(), GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE,
															GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(
											gl_panel
													.createParallelGroup(Alignment.BASELINE)
													.addComponent(getLblCpf())
													.addComponent(getTfCpf(), GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE,
															GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(
											gl_panel
													.createParallelGroup(Alignment.BASELINE)
													.addComponent(getLblEmail())
													.addComponent(getTfEmail(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE,
															GroupLayout.PREFERRED_SIZE))
									.addContainerGap(26, Short.MAX_VALUE)));
			panel.setLayout(gl_panel);
		}
		return panel;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(
					Alignment.LEADING).addGroup(
					gl_panel_1
							.createSequentialGroup()
							.addContainerGap()
							.addGroup(
									gl_panel_1
											.createParallelGroup(Alignment.LEADING)
											.addGroup(
													gl_panel_1
															.createSequentialGroup()
															.addComponent(getLblCnpj())
															.addPreferredGap(ComponentPlacement.RELATED)
															.addComponent(getTfCnpj(),
																	GroupLayout.PREFERRED_SIZE, 250,
																	GroupLayout.PREFERRED_SIZE))
											.addGroup(
													gl_panel_1
															.createSequentialGroup()
															.addComponent(getLblIncrEst())
															.addPreferredGap(ComponentPlacement.RELATED)
															.addComponent(getTfIe(),
																	GroupLayout.PREFERRED_SIZE, 239,
																	GroupLayout.PREFERRED_SIZE))
											.addGroup(
													gl_panel_1
															.createSequentialGroup()
															.addComponent(getLblSite())
															.addPreferredGap(ComponentPlacement.RELATED)
															.addComponent(getTfSite(),
																	GroupLayout.PREFERRED_SIZE, 249,
																	GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(60, Short.MAX_VALUE)));
			gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(
					Alignment.LEADING)
					.addGroup(
							gl_panel_1
									.createSequentialGroup()
									.addContainerGap()
									.addGroup(
											gl_panel_1
													.createParallelGroup(Alignment.BASELINE)
													.addComponent(getLblCnpj())
													.addComponent(getTfCnpj(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE,
															GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(
											gl_panel_1
													.createParallelGroup(Alignment.BASELINE)
													.addComponent(getLblIncrEst())
													.addComponent(getTfIe(), GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE,
															GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(
											gl_panel_1
													.createParallelGroup(Alignment.BASELINE)
													.addComponent(getLblSite())
													.addComponent(getTfSite(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE,
															GroupLayout.PREFERRED_SIZE))
									.addContainerGap(26, Short.MAX_VALUE)));
			panel_1.setLayout(gl_panel_1);
		}
		return panel_1;
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

	private JLabel getLblFone() {
		if (lblFone == null) {
			lblFone = new JLabel("Fone");
		}
		return lblFone;
	}

	private JTextField getTfFone() {
		if (tfFone == null) {
			tfFone = new JTextField();
			tfFone.setColumns(10);
		}
		return tfFone;
	}

	private JLabel getLblRg() {
		if (lblRg == null) {
			lblRg = new JLabel("RG");
		}
		return lblRg;
	}

	private JTextField getTfRg() {
		if (tfRg == null) {
			tfRg = new JTextField();
			tfRg.setColumns(10);
		}
		return tfRg;
	}

	private JLabel getLblCpf() {
		if (lblCpf == null) {
			lblCpf = new JLabel("CPF");
		}
		return lblCpf;
	}

	private JTextField getTfCpf() {
		if (tfCpf == null) {
			tfCpf = new JTextField();
			tfCpf.setColumns(10);
		}
		return tfCpf;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-Mail");
		}
		return lblEmail;
	}

	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
		}
		return tfEmail;
	}

	private JLabel getLblCnpj() {
		if (lblCnpj == null) {
			lblCnpj = new JLabel("CNPJ");
		}
		return lblCnpj;
	}

	private JTextField getTfCnpj() {
		if (tfCnpj == null) {
			tfCnpj = new JTextField();
			tfCnpj.setColumns(10);
		}
		return tfCnpj;
	}

	private JLabel getLblIncrEst() {
		if (lblIncrEst == null) {
			lblIncrEst = new JLabel("Incr. Est.");
		}
		return lblIncrEst;
	}

	private JTextField getTfIe() {
		if (tfIe == null) {
			tfIe = new JTextField();
			tfIe.setColumns(10);
		}
		return tfIe;
	}

	private JLabel getLblSite() {
		if (lblSite == null) {
			lblSite = new JLabel("Site");
		}
		return lblSite;
	}

	private JTextField getTfSite() {
		if (tfSite == null) {
			tfSite = new JTextField();
			tfSite.setColumns(10);
		}
		return tfSite;
	}

	private JButton getBtInserir() {
		if (btInserir == null) {
			btInserir = new JButton("Inserir");
			btInserir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int op = tabbedPane.getSelectedIndex();
					
					if (op == 0) {
						PessoaFisica p = new PessoaFisica();
						p.setNome(tfNome.getText());
						p.setFone(tfFone.getText());
						p.setRg(tfRg.getText());
						p.setCpf(tfCpf.getText());
						p.setEmail(tfEmail.getText());

						p.setEndereco(end);

						lista.add(p);
						tfRg.setText("");
						tfCpf.setText("");
						tfEmail.setText("");
					} else {
						PessoaJuridica p = new PessoaJuridica();
						p.setNome(tfNome.getText());
						p.setFone(tfFone.getText());
						p.setCnpj(tfCnpj.getText());
						p.setInscrEst(tfIe.getText());
						p.setSite(tfSite.getText());

						p.setEndereco(end);

						lista.add(p);
						tfCnpj.setText("");
						tfIe.setText("");
						tfSite.setText("");
					}
					
					tfNome.setText("");
					tfNome.requestFocus();
					tfFone.setText("");
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
					String txt = "Cadastro de Pessoas\n\n";
					for (int i = 0; i < lista.size(); i++) {
						txt = txt + lista.get(i) + "\n";
					}
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
	private JLabel getLblEnd() {
		if (lblEnd == null) {
			lblEnd = new JLabel("End.");
		}
		return lblEnd;
	}
	private JButton getBtEnd() {
		if (btEnd == null) {
			btEnd = new JButton("...");
			btEnd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CadEndereco dialog = new CadEndereco();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

					end = dialog.getEndereco();
				}
			});
		}
		return btEnd;
	}
}
