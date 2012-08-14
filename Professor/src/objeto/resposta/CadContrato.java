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
		contentPane.setLayout(null);
		contentPane.add(getLblN());
		contentPane.add(getTfNum());
		contentPane.add(getLblAno());
		contentPane.add(getTfAno());
		contentPane.add(getLblDescr());
		contentPane.add(getTfDescr());
		contentPane.add(getBtInserir());
		contentPane.add(getBtListar());
		contentPane.add(getBtSair());
	}

	private JLabel getLblN() {
		if (lblN == null) {
			lblN = new JLabel("N.");
			lblN.setBounds(17, 17, 15, 15);
		}
		return lblN;
	}

	private JTextField getTfNum() {
		if (tfNum == null) {
			try {
				MaskFormatter mascara = new MaskFormatter("####");
				tfNum = new JFormattedTextField(mascara);
				tfNum.setBounds(50, 17, 114, 19);
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
			lblAno.setBounds(193, 19, 27, 15);
		}
		return lblAno;
	}

	private JTextField getTfAno() {
		if (tfAno == null) {
			
			// Cria uma mascara de edicao para o campo Ano
			try {
				MaskFormatter mascara = new MaskFormatter("####");
				tfAno = new JFormattedTextField(mascara);
				tfAno.setBounds(246, 17, 91, 19);
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
			lblDescr.setBounds(17, 54, 45, 15);
		}
		return lblDescr;
	}

	private JTextField getTfDescr() {
		if (tfDescr == null) {
			tfDescr = new JTextField();
			tfDescr.setBounds(80, 54, 257, 19);
			tfDescr.setColumns(10);
		}
		return tfDescr;
	}

	private JButton getBtInserir() {
		if (btInserir == null) {
			btInserir = new JButton("Inserir");
			btInserir.setBounds(58, 104, 80, 25);
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
			btListar.setBounds(156, 104, 75, 25);
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
			btSair.setBounds(249, 104, 62, 25);
			btSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return btSair;
	}
}
