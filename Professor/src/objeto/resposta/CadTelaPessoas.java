package objeto.resposta;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class CadTelaPessoas extends JFrame {
  private CadTelaPessoas telaPrincipal = this; 
	private JPanel contentPane;
	private JLabel lbNome;
	private JTextField tfNome;
	private JLabel lbFone;
	private JTextField tfFone;
	private JLabel lblEnd;
	private JButton btEnd;
	private JTabbedPane tab;
	private JPanel pnFisica;
	private JPanel pnJuridica;
	private JLabel lblCnpj;
	private JTextField tfCnpj;
	private JLabel lblIe;
	private JTextField tfIe;
	private JLabel lblSite;
	private JTextField tfSite;
	private JLabel lblRg;
	private JTextField tfRg;
	private JLabel lblCpf;
	private JTextField tfCpf;
	private JLabel lblEmail;
	private JTextField tfEmail;
	private JButton btnInserir;
	private JButton btnListar;
	private JButton btnSair;
	private ArrayList<Pessoa> lista = new ArrayList<>();
	private Endereco end = new Endereco(); 

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
		setBounds(100, 100, 354, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbNome());
		contentPane.add(getTfNome());
		contentPane.add(getLbFone());
		contentPane.add(getTfFone());
		contentPane.add(getLblEnd());
		contentPane.add(getBtEnd());
		contentPane.add(getTab());
		contentPane.add(getBtnInserir());
		contentPane.add(getBtnListar());
		contentPane.add(getBtnSair());
	}

	private JLabel getLbNome() {
		if (lbNome == null) {
			lbNome = new JLabel("Nome");
			lbNome.setBounds(12, 12, 70, 15);
		}
		return lbNome;
	}

	private JTextField getTfNome() {
		if (tfNome == null) {
			tfNome = new JTextField();
			tfNome.setBounds(64, 12, 232, 19);
			tfNome.setColumns(10);
		}
		return tfNome;
	}

	private JLabel getLbFone() {
		if (lbFone == null) {
			lbFone = new JLabel("Fone");
			lbFone.setBounds(12, 39, 70, 15);
		}
		return lbFone;
	}

	private JTextField getTfFone() {
		if (tfFone == null) {
			tfFone = new JTextField();
			tfFone.setBounds(64, 39, 114, 19);
			tfFone.setColumns(10);
		}
		return tfFone;
	}

	private JLabel getLblEnd() {
		if (lblEnd == null) {
			lblEnd = new JLabel("End.");
			lblEnd.setBounds(196, 39, 70, 15);
		}
		return lblEnd;
	}

	private JButton getBtEnd() {
		if (btEnd == null) {
			btEnd = new JButton("...");
			btEnd.setBounds(253, 34, 49, 25);
			btEnd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CadEndereco tela = new CadEndereco(end, telaPrincipal);
					tela.setVisible(true);
				}
			});
		}
		return btEnd;
	}

	private JTabbedPane getTab() {
		if (tab == null) {
			tab = new JTabbedPane(JTabbedPane.TOP);
			tab.setBounds(12, 78, 328, 155);
			tab.addTab("Fisica", null, getPnFisica(), null);
			tab.addTab("Juridica", null, getPnJuridica(), null);
		}
		return tab;
	}

	private JPanel getPnFisica() {
		if (pnFisica == null) {
			pnFisica = new JPanel();
			pnFisica.setLayout(null);
			pnFisica.add(getLblRg());
			pnFisica.add(getTfRg());
			pnFisica.add(getLblCpf());
			pnFisica.add(getTgCpf());
			pnFisica.add(getLblEmail());
			pnFisica.add(getTfEmail());
		}
		return pnFisica;
	}

	private JPanel getPnJuridica() {
		if (pnJuridica == null) {
			pnJuridica = new JPanel();
			pnJuridica.setLayout(null);
			pnJuridica.add(getLblCnpj());
			pnJuridica.add(getTfCnpj());
			pnJuridica.add(getLblIe());
			pnJuridica.add(getTfIe());
			pnJuridica.add(getLblSite());
			pnJuridica.add(getTfSite());
		}
		return pnJuridica;
	}

	private JLabel getLblCnpj() {
		if (lblCnpj == null) {
			lblCnpj = new JLabel("CNPJ");
			lblCnpj.setBounds(12, 16, 32, 15);
		}
		return lblCnpj;
	}

	private JTextField getTfCnpj() {
		if (tfCnpj == null) {
			tfCnpj = new JTextField();
			tfCnpj.setBounds(62, 12, 201, 19);
			tfCnpj.setColumns(10);
		}
		return tfCnpj;
	}

	private JLabel getLblIe() {
		if (lblIe == null) {
			lblIe = new JLabel("I.E.");
			lblIe.setBounds(12, 53, 22, 15);
		}
		return lblIe;
	}

	private JTextField getTfIe() {
		if (tfIe == null) {
			tfIe = new JTextField();
			tfIe.setBounds(52, 49, 211, 19);
			tfIe.setColumns(10);
		}
		return tfIe;
	}

	private JLabel getLblSite() {
		if (lblSite == null) {
			lblSite = new JLabel("Site");
			lblSite.setBounds(12, 90, 28, 15);
		}
		return lblSite;
	}

	private JTextField getTfSite() {
		if (tfSite == null) {
			tfSite = new JTextField();
			tfSite.setBounds(58, 86, 205, 19);
			tfSite.setColumns(10);
		}
		return tfSite;
	}

	private JLabel getLblRg() {
		if (lblRg == null) {
			lblRg = new JLabel("RG");
			lblRg.setBounds(12, 16, 19, 15);
		}
		return lblRg;
	}

	private JTextField getTfRg() {
		if (tfRg == null) {
			tfRg = new JTextField();
			tfRg.setBounds(49, 12, 204, 19);
			tfRg.setColumns(10);
		}
		return tfRg;
	}

	private JLabel getLblCpf() {
		if (lblCpf == null) {
			lblCpf = new JLabel("CPF");
			lblCpf.setBounds(12, 53, 26, 15);
		}
		return lblCpf;
	}

	private JTextField getTgCpf() {
		if (tfCpf == null) {
			tfCpf = new JTextField();
			tfCpf.setBounds(56, 49, 209, 19);
			tfCpf.setColumns(10);
		}
		return tfCpf;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-Mail");
			lblEmail.setBounds(12, 90, 42, 15);
		}
		return lblEmail;
	}

	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setBounds(72, 86, 193, 19);
			tfEmail.setColumns(10);
		}
		return tfEmail;
	}

	private JButton getBtnInserir() {
		if (btnInserir == null) {
			btnInserir = new JButton("Inserir");
			btnInserir.setBounds(33, 256, 80, 25);
			btnInserir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int op = tab.getSelectedIndex();
					if(op == 0) { // Pessoa Fisica
						PessoaFisica pf = new PessoaFisica();
						pf.setNome(tfNome.getText());
						pf.setFone(tfFone.getText());
						pf.setEndereco(end);
						pf.setRg(tfRg.getText());
					  pf.setCpf(tfCpf.getText());
					  pf.setEmail(tfEmail.getText());
					  lista.add(pf);
					} else { // Pessoa Juridica
						PessoaJuridica pj = new PessoaJuridica();
						pj.setNome(tfNome.getText());
						pj.setFone(tfFone.getText());
						pj.setEndereco(end);
						pj.setCnpj(tfCnpj.getText());
					  pj.setInscrEst(tfIe.getText());
					  pj.setSite(tfSite.getText());
					  lista.add(pj);
					}
					tfNome.setText("");
					tfNome.requestFocus();
					tfFone.setText("");
					tfRg.setText("");
					tfCpf.setText("");
					tfEmail.setText("");
					tfCnpj.setText("");
					tfIe.setText("");
					tfSite.setText("");
					end = new Endereco();
				}
			});
		}
		return btnInserir;
	}

	private JButton getBtnListar() {
		if (btnListar == null) {
			btnListar = new JButton("Listar");
			btnListar.setBounds(146, 256, 75, 25);
			btnListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String txt = "Cad. de Pessoas\n\n";
					for (int i = 0; i < lista.size(); i++) {
						txt += lista.get(i) + "\n";
					}
					JOptionPane.showMessageDialog(null, txt);
				}
			});
		}
		return btnListar;
	}

	private JButton getBtnSair() {
		if (btnSair == null) {
			btnSair = new JButton("Sair");
			btnSair.setBounds(254, 256, 62, 25);
			btnSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return btnSair;
	}
}
