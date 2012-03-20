package api.jdbc.resposta;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ContratoModel extends AbstractTableModel {
	private ContratoDao dao = ContratoDao.getInstance();
	
	public void add(Contrato contr) throws Exception {
		dao.add(contr);
		fireTableDataChanged();
	}
	
	public void del(int row) throws Exception {
		dao.del(row);
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return dao.count();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int column) {
		String nome = "";
		switch(column) {
		case 0:
			nome = "No.";
			break;
		case 1:
			nome = "Descr.";
			break;
		}
		return nome;
	}

	@Override
	public Object getValueAt(int row, int column) {
		try {
			Contrato obj = dao.get(row);

			Object valor = "";
			switch(column) {
			case 0:
				valor = obj.getNumero();
				break;
			case 1:
				valor = obj.getDescricao();
				break;
			}
			return valor;
		} catch(Exception ex) {
			return null;
		}
	}

}
