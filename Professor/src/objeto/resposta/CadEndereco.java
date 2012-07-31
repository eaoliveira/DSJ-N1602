package objeto.resposta;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import objeto.respostas.Endereco;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CadEndereco extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private Endereco end;
	private JTextField tfLogr;
	private JTextField tfNum;
	private JTextField tfBairro;
	private JTextField tfCompl;
	private JTextField tfCep;
	private JTextField tfCidade;
	private JTextField tfUF;

	public Endereco getEndereco() {
		return end;
	}

	public CadEndereco() {
		setModal(true);
		setBounds(100, 100, 381, 229);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblLogr = new JLabel("Logr.");
		
		tfLogr = new JTextField();
		tfLogr.setColumns(10);
		
		JLabel lblN = new JLabel("N.");
		
		tfNum = new JTextField();
		tfNum.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		
		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		
		JLabel lblCompl = new JLabel("Compl.");
		
		tfCompl = new JTextField();
		tfCompl.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		
		tfCep = new JTextField();
		tfCep.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		
		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		
		JLabel lblF = new JLabel("UF");
		
		tfUF = new JTextField();
		tfUF.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblLogr)
								.addGap(30)
								.addComponent(tfLogr, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblN)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(tfNum, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblBairro)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(tfBairro))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblCompl)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(tfCompl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblCep)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(tfCep, 0, 0, Short.MAX_VALUE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblCidade)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfCidade, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblF)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfUF, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogr)
						.addComponent(tfLogr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblN)
						.addComponent(tfNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBairro)
						.addComponent(tfBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCompl)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(tfCompl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblCep)
							.addComponent(tfCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCidade)
						.addComponent(tfCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblF)
						.addComponent(tfUF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("Salvar");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				end = new Endereco();
				end.setLogradouro(tfLogr.getText());
				end.setNumero(tfNum.getText());
				end.setBairro(tfBairro.getText());
				end.setComplemento(tfCompl.getText());
				end.setCep(tfCep.getText());
			  end.setCidade(tfCidade.getText());
			  end.setEstado(tfUF.getText());
				setVisible(false);
			}
		});
		okButton.setActionCommand("Salvar");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Sair");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		cancelButton.setActionCommand("Sair");
		buttonPane.add(cancelButton);

	}

}
