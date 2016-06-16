package cliente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.text.xml.Nome;

public class TesteNome {
	private static JTextField tfNome = new JTextField(15);
	private static JTextField tfIdade = new JTextField(3);

	public static void main(String[] args) {
		try {
			final DefaultTableModel tab = new MyModel(new NomeWsDao());
			final JTable table = new JTable(tab);
			table.setAutoCreateRowSorter(true);
			JScrollPane scrollPane = new JScrollPane(table);

			JPanel campo = new JPanel();
			campo.add(new JLabel("Nome"));
			campo.add(tfNome);
			campo.add(new JLabel(" Idade"));
			campo.add(tfIdade);

			JButton btAdd = new JButton("Adicionar");
			btAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					tab.addRow(new Object[] { tfNome.getText(),
							Integer.parseInt(tfIdade.getText()) });
					tfNome.setText("");
					tfIdade.setText("");
					tfNome.requestFocus();
				}
			});

			JButton btRemove = new JButton("Remover");
			btRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					int i = table.getSelectedRow();
					if (i >= 0)
						tab.removeRow(table.convertRowIndexToModel(i));
				}
			});

			JButton btSair = new JButton("Sair");
			btSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					System.exit(0);
				}
			});

			JPanel botao = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
			botao.add(btAdd);
			botao.add(btRemove);
			botao.add(btSair);

			JFrame frame = new JFrame("Sorting Table");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(campo, BorderLayout.NORTH);
			frame.add(scrollPane, BorderLayout.CENTER);
			frame.add(botao, BorderLayout.SOUTH);
			frame.getRootPane().setDefaultButton(btAdd);
			frame.setPreferredSize(new Dimension(350, 200));
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);

			new Thread() {
				public void run() {
					try {
						while (true) {
							tab.fireTableDataChanged();
							Thread.sleep(5000);
						}
					} catch (Exception ex) {
					}
				}
			}.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

@SuppressWarnings("serial")
class MyModel extends DefaultTableModel {
	private static List<Integer> ids = new ArrayList<Integer>();
	private NomeWsDao model;

	public MyModel(NomeWsDao model) {
		try {
			this.model = model;

			reloadIds();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void reloadIds() {
		ids.clear();

		for (Nome n : model.listaTodos())
			ids.add(n.getId());
	}

	public Class<?> getColumnClass(int column) {
		Class<?> clazz = null;
		switch (column) {
		case 0:
			clazz = String.class;
			break;
		case 1:
			clazz = Integer.class;
			break;
		}

		return clazz;
	}

	@Override
	public void addRow(Object[] rowData) {
		Nome n = new Nome();
		n.setPrimeiroNome((String) rowData[0]);
		n.setIdade((Integer) rowData[1]);
		model.salvar(n);
		reloadIds();
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int column) {
		String nome = null;
		switch (column) {
		case 0:
			nome = "Nome";
			break;
		case 1:
			nome = "Idade";
			break;
		}

		return nome;
	}

	@Override
	public int getRowCount() {
		int cnt = 0;

		if (model != null)
			cnt = (int) model.quantos();

		if (cnt != ids.size()) {
			reloadIds();
			fireTableDataChanged();
		}

		return cnt;
	}

	@Override
	public Object getValueAt(int row, int column) {
		int i = row;
		Nome n;
		Object obj = null;

		try {
			n = model.buscar(ids.get(i));

			switch (column) {
			case 0:
				obj = n.getPrimeiroNome();
				break;
			case 1:
				obj = n.getIdade();
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return obj;
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return true;
	}

	@Override
	public void removeRow(int row) {
		int i = row;
		Nome n;

		try {
			n = model.buscar(ids.get(i));
			model.remover(n.getId());
			reloadIds();
			fireTableDataChanged();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		int i = row;
		Nome n = null;

		try {
			n = model.buscar(ids.get(i));

			switch (column) {
			case 0:
				n.setPrimeiroNome((String) aValue);
				break;
			case 1:
				n.setIdade((Integer) aValue);
				break;
			}

			model.atualizar(n);
			fireTableDataChanged();
		} catch (Exception ex) {
			reloadIds();
			fireTableDataChanged();
		}
	}

}
