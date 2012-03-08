package objeto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import objeto.resposta.Endereco;

@SuppressWarnings("serial")
public class TelaEndereco extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfLogr;
	private JTextField tfNum;
	private JTextField tfCompl;
	private JTextField tfBairro;
	private JTextField tfCep;
	private JTextField tfCidade;
	private JTextField tfUf;
	private Endereco end;

	public Endereco getEndereco() {
		return end;
	}

	public TelaEndereco() {
		setModal(true);
		setTitle("Endereço");
		setBounds(100, 100, 421, 209);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblLogr = new JLabel("Logr.");
		lblLogr.setBounds(17, 19, 37, 15);

		tfLogr = new JTextField();
		tfLogr.setBounds(66, 17, 337, 19);
		tfLogr.setColumns(10);

		JLabel lblNo = new JLabel("No.");
		lblNo.setBounds(17, 50, 24, 15);

		tfNum = new JTextField();
		tfNum.setBounds(53, 48, 56, 19);
		tfNum.setColumns(10);

		JLabel lblCompl = new JLabel("Compl");
		lblCompl.setBounds(127, 50, 43, 15);

		tfCompl = new JTextField();
		tfCompl.setBounds(188, 48, 215, 19);
		tfCompl.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(17, 79, 43, 15);

		tfBairro = new JTextField();
		tfBairro.setBounds(78, 79, 169, 19);
		tfBairro.setColumns(10);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(17, 110, 26, 15);

		tfCep = new JTextField();
		tfCep.setBounds(55, 110, 71, 19);
		tfCep.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(138, 112, 49, 15);

		tfCidade = new JTextField();
		tfCidade.setBounds(199, 110, 204, 19);
		tfCidade.setColumns(10);

		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(259, 81, 18, 15);

		tfUf = new JTextField();
		tfUf.setBounds(289, 79, 114, 19);
		tfUf.setColumns(10);
		
		contentPanel.setLayout(null);
		contentPanel.add(lblLogr);
		contentPanel.add(tfLogr);
		contentPanel.add(lblNo);
		contentPanel.add(tfNum);
		contentPanel.add(lblCompl);
		contentPanel.add(tfCompl);
		contentPanel.add(lblBairro);
		contentPanel.add(tfBairro);
		contentPanel.add(lblUf);
		contentPanel.add(tfUf);
		contentPanel.add(lblCep);
		contentPanel.add(tfCep);
		contentPanel.add(lblCidade);
		contentPanel.add(tfCidade);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				end = new Endereco();
				end.setLogradouro(tfLogr.getText());
				end.setNumero(tfNum.getText());
				setVisible(false);
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				end = null;
				setVisible(false);
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}
}
