package api.colecoes.resposta;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

@SuppressWarnings("serial")
public class CadAlunoTable extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblMatricula;
	private JTextField tfMatr;
	private JLabel lblNome;
	private JTextField tfNome;
	private JButton btnInserir;
	private JButton btnSair;
	private JScrollPane scrollPane;
	private JTable table;
	private AlunoModel model;
	private JButton btnExcluir;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadAlunoTable frame = new CadAlunoTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadAlunoTable() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getLblNome());
		contentPane.add(getTfNome());
		contentPane.add(getLblMatricula());
		contentPane.add(getTfMatr());
		contentPane.add(getBtnInserir());
		contentPane.add(getBtnExcluir());
		contentPane.add(getBtnSair());
	}

	private JLabel getLblMatricula() {
		if (lblMatricula == null) {
			lblMatricula = new JLabel("Matricula");
			lblMatricula.setBounds(228, 19, 72, 14);
		}
		return lblMatricula;
	}

	private JTextField getTfMatr() {
		if (tfMatr == null) {
			tfMatr = new JTextField();
			tfMatr.setBounds(318, 17, 86, 20);
			tfMatr.setColumns(10);
		}
		return tfMatr;
	}

	private JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel("Nome");
			lblNome.setBounds(15, 19, 48, 14);
		}
		return lblNome;
	}

	private JTextField getTfNome() {
		if (tfNome == null) {
			tfNome = new JTextField();
			tfNome.setBounds(60, 16, 150, 20);
			tfNome.setColumns(10);
		}
		return tfNome;
	}

	private JButton getBtnInserir() {
		if (btnInserir == null) {
			btnInserir = new JButton("Inserir");
			btnInserir.setBounds(59, 48, 80, 25);
			btnInserir.addActionListener(this);
			btnInserir.setMnemonic('i');
		}
		return btnInserir;
	}

	private JButton getBtnExcluir() {
		if (btnExcluir == null) {
			btnExcluir = new JButton("Excluir");
			btnExcluir.setBounds(189, 48, 79, 25);
			btnExcluir.addActionListener(this);
		}
		return btnExcluir;
	}

	private JButton getBtnSair() {
		if (btnSair == null) {
			btnSair = new JButton("Sair");
			btnSair.setBounds(309, 48, 62, 25);
			btnSair.addActionListener(this);
			btnSair.setMnemonic('s');
		}
		return btnSair;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(15, 95, 412, 120);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(getModel());

			table.setAutoCreateRowSorter(true);

			TableColumn cm = table.getColumnModel().getColumn(0);
			cm.setCellEditor(new DefaultCellEditor(new JTextField()));
			cm = table.getColumnModel().getColumn(1);
			cm.setCellEditor(new DefaultCellEditor(new JTextField()));

		}
		return table;
	}

	private AlunoModel getModel() {
		if (model == null) {
			model = new AlunoModel();
		}
		return model;
	}

	public void actionPerformed(ActionEvent ev) {
		String cmd = ev.getActionCommand();

		if (cmd.equals("Inserir")) {
			Aluno a = new Aluno();
			a.setNome(tfNome.getText());
			a.setMatricula(tfMatr.getText());
			getModel().add(a);

			tfNome.setText("");
			tfNome.requestFocus();
			tfMatr.setText("");
		} else if(cmd.equals("Excluir")) {
			int row = getTable().getSelectedRow();
			if(row != -1) {
				row = getTable().convertRowIndexToModel(row);
			  getModel().del(row);
			} else
				JOptionPane.showMessageDialog(this, "Nenhuma linha foi Selecionada!");
		} else {
			System.exit(0);
		}
	}
}
