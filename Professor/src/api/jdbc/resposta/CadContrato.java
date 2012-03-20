package api.jdbc.resposta;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class CadContrato extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JLabel lblNo;
	private JTextField tfNum;
	private JLabel lblDescr;
	private JTextField tfDescr;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btInserir;
	private JButton btApagar;
	private JButton btSair;
	private ContratoModel model = new ContratoModel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadContrato frame = new CadContrato();
					frame.setPreferredSize(new Dimension(450,290));
					frame.setMinimumSize(new Dimension(350,250));
					frame.pack();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadContrato() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(getScrollPane(), GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(getLblNo())
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(getTfNum(), GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(getLblDescr())
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(getTfDescr(), GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(getBtInserir())
							.addGap(18)
							.addComponent(getBtApagar())
							.addGap(18)
							.addComponent(getBtSair())))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(getTfNum(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(getLblNo()))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(getLblDescr())
						.addComponent(getTfDescr(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(getScrollPane(), GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(getBtInserir())
						.addComponent(getBtApagar())
						.addComponent(getBtSair()))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	public JLabel getLblNo() {
		if (lblNo == null) {
			lblNo = new JLabel("No.");
		}
		return lblNo;
	}

	public JTextField getTfNum() {
		if (tfNum == null) {
			tfNum = new JTextField();
			tfNum.setColumns(10);
		}
		return tfNum;
	}

	public JLabel getLblDescr() {
		if (lblDescr == null) {
			lblDescr = new JLabel("Descr.");
		}
		return lblDescr;
	}

	public JTextField getTfDescr() {
		if (tfDescr == null) {
			tfDescr = new JTextField();
			tfDescr.setColumns(10);
		}
		return tfDescr;
	}

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(model);
			table.setAutoCreateRowSorter(true);
		}
		return table;
	}

	public JButton getBtInserir() {
		if (btInserir == null) {
			btInserir = new JButton("Inserir");
			btInserir.addActionListener(this);
			btInserir.setMnemonic('i');
		}
		return btInserir;
	}

	public JButton getBtApagar() {
		if (btApagar == null) {
			btApagar = new JButton("Apagar");
			btApagar.addActionListener(this);
			btApagar.setMnemonic('a');
		}
		return btApagar;
	}

	public JButton getBtSair() {
		if (btSair == null) {
			btSair = new JButton("Sair");
			btSair.addActionListener(this);
		}
		return btSair;
	}

	public void actionPerformed(ActionEvent ev) {
		try {
		String cmd = ev.getActionCommand();
		
		if(cmd.equals("Inserir")) {
			Contrato con = new Contrato();
			con.setNumero(tfNum.getText());
			con.setDescricao(tfDescr.getText());
			model.add(con);
		} else if(cmd.equals("Apagar")) {
			model.del(table.convertRowIndexToModel(table.getSelectedRow()));
		} else {
			System.exit(0);
		}
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(this, "Erro:\n" + ex.getMessage());
		}
	}
}
