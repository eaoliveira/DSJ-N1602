package objeto.resposta;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class CadContrato extends JFrame {
	private Contrato[] lista = new Contrato[3];
	private int idx = 0;
	
	private JPanel contentPane;
	private JButton btInserir;
	private JButton btListar;
	private JButton btSair;
	private JTextField tfNum;
	private JTextField tfAno;
	private JTextField tfDescr;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public CadContrato() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2);

		JLabel lblN = new JLabel("Nº");
		panel_2.add(lblN);

		tfNum = new JTextField();
		panel_2.add(tfNum);
		tfNum.setColumns(5);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setMinimumSize(new Dimension(10, 0));
		panel_2.add(horizontalGlue);

		JLabel lblAno = new JLabel("Ano");
		panel_2.add(lblAno);

		tfAno = new JTextField();
		panel_2.add(tfAno);
		tfAno.setColumns(10);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_1);

		JLabel lblDescr = new JLabel("Descr.");
		panel_1.add(lblDescr);

		tfDescr = new JTextField();
		panel_1.add(tfDescr);
		tfDescr.setColumns(10);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setHgap(15);
		contentPane.add(panel_3, BorderLayout.SOUTH);

		btInserir = new JButton("Inserir");
		btInserir.setMnemonic('I');
		btInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Contrato c = new Contrato();
					c.setNumero(Integer.parseInt(tfNum.getText()));
					c.setAno(Integer.parseInt(tfAno.getText()));
					c.setDescricao(tfDescr.getText());
					lista[idx++] = c;
					tfNum.setText("");
					tfNum.requestFocus();
					tfAno.setText("");
					tfDescr.setText("");
				if(idx >= 3) {
					tfNum.setEditable(false);
					tfAno.setEditable(false);
					tfDescr.setEditable(false);
					btInserir.setEnabled(false);
					getRootPane().setDefaultButton(btListar);
				}
			}
		});
		panel_3.add(btInserir);

		btListar = new JButton("Listar");
		btListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder txt = new StringBuilder("Cad de Contratos\n\n");
				for (int i = 0; i < idx; i++) {
					Contrato c = lista[i];
					txt.append(c + "\n");
				}
				JOptionPane.showMessageDialog(null, txt.toString());
				
				lista = new Contrato[3];
				idx = 0;
				tfNum.setEditable(true);
				tfAno.setEditable(true);
				tfDescr.setEditable(true);
				btInserir.setEnabled(true);
				getRootPane().setDefaultButton(btInserir);
			}
		});
		panel_3.add(btListar);

		btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_3.add(btSair);
		
		
		getRootPane().setDefaultButton(btInserir);
	}

  
}
