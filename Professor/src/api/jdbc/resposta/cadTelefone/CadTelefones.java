package api.jdbc.resposta.cadTelefone;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import api.jdbc.resposta.acessoDb.DbException;

@SuppressWarnings("serial")
public class CadTelefones extends JFrame {

	private JPanel contentPane;
	private JLabel lblDdd;
	private JTextField tfDdd;
	private JLabel lblN;
	private JTextField tfNum;
	private JLabel lblTipo;
	private JComboBox<TipoFone> cbTipo;
	private JButton btSalvar;
	private JButton btListar;
	private JButton btSair;
	private TelefoneDao dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new CadTelefones();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadTelefones() {
		try {
			dao = new TelefoneDao();

			setTitle("Cadastro de Telefones");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 488, 149);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			contentPane.add(getLblDdd());
			contentPane.add(getTfDdd());
			contentPane.add(getLblN());
			contentPane.add(getBtSalvar());
			contentPane.add(getTfNum());
			contentPane.add(getLblTipo());
			contentPane.add(getCbTipo());
			contentPane.add(getBtListar());
			contentPane.add(getBtSair());
			setVisible(true);
		} catch (DbException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	private JLabel getLblDdd() {
		if (lblDdd == null) {
			lblDdd = new JLabel("DDD");
			lblDdd.setBounds(17, 17, 30, 15);
		}
		return lblDdd;
	}

	private JTextField getTfDdd() {
		if (tfDdd == null) {
			tfDdd = new JTextField();
			tfDdd.setBounds(65, 17, 66, 19);
			tfDdd.setColumns(10);
		}
		return tfDdd;
	}

	private JLabel getLblN() {
		if (lblN == null) {
			lblN = new JLabel("Nº");
			lblN.setBounds(137, 19, 17, 15);
		}
		return lblN;
	}

	private JTextField getTfNum() {
		if (tfNum == null) {
			tfNum = new JTextField();
			tfNum.setBounds(166, 17, 114, 19);
			tfNum.setColumns(10);
		}
		return tfNum;
	}

	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Tipo");
			lblTipo.setBounds(292, 19, 30, 15);
		}
		return lblTipo;
	}

	private JComboBox<TipoFone> getCbTipo() {
		if (cbTipo == null) {
			cbTipo = new JComboBox<TipoFone>();
			cbTipo.setBounds(334, 17, 133, 24);
			cbTipo.setModel(new DefaultComboBoxModel<TipoFone>(TipoFone.values()));
		}
		return cbTipo;
	}

	private JButton getBtSalvar() {
		if (btSalvar == null) {
			btSalvar = new JButton("Salvar");
			btSalvar.setBounds(65, 79, 78, 25);
			btSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Fone f = new Fone();
						f.setDdd(tfDdd.getText());
						f.setNumero(tfNum.getText());
						f.setTipo((TipoFone) cbTipo.getSelectedItem());

						dao.salva(f);

						tfDdd.setText("");
						tfNum.setText("");
						cbTipo.setSelectedIndex(0);
						tfDdd.requestFocus();
					} catch (DbException ex) {
						JOptionPane.showMessageDialog(null,
								"Erro:\n" + ex.getLocalizedMessage());
					}
				}
			});
		}
		return btSalvar;
	}

	private JButton getBtListar() {
		if (btListar == null) {
			btListar = new JButton("Listar");
			btListar.setBounds(192, 79, 75, 25);
			btListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						StringBuilder msg = new StringBuilder("Cadastro de Telefones\n\n");
						List<Fone> lista = dao.getFones();
						for (Fone fone : lista)
							msg.append(fone + "\n");
						JOptionPane.showMessageDialog(null, msg);
					} catch (DbException ex) {
						JOptionPane.showMessageDialog(null,
								"Erro:\n" + ex.getLocalizedMessage());
					}
				}
			});
		}
		return btListar;
	}

	private JButton getBtSair() {
		if (btSair == null) {
			btSair = new JButton("Sair");
			btSair.setBounds(310, 79, 62, 25);
			btSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return btSair;
	}
}
