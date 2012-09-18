package api.colecoes.resposta;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import objeto.old.Fone;
import objeto.old.TipoFone;

@SuppressWarnings("serial")
public class FoneTable extends AbstractTableModel {
	private List<Fone> fones;

	public FoneTable(List<Fone> f) {
		super();
		this.fones = f;
	}

	public void add(Fone f) {
		fones.add(f);
		fireTableDataChanged();
	}

	public void del(int row) {
		fones.remove(row);
		fireTableDataChanged();
	}

	public int getColumnCount() {
		return 3;
	}

	public int getRowCount() {
		if (fones == null)
			return 0;
		else
			return fones.size();
	}

	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Tipo";
		case 1:
			return "DDD";
		case 2:
			return "N�mero";
		default:
			return null;
		}
	}

	public Object getValueAt(int row, int col) {
		Fone f = fones.get(row);
		switch (col) {
		case 0:
			return f.getTipo().toString();
		case 1:
			return f.getDdd();
		case 2:
			return f.getNumero();
		default:
			return null;
		}
	}

	public void setValueAt(Object value, int row, int col) {
		Fone f = fones.get(row);

		switch (col) {
		case 0:
			f.setTipo((TipoFone) value);
			break;
		case 1:
			f.setDdd((String) value);
			break;
		case 2:
			f.setNumero((String) value);
			break;
		default:
			break;
		}
	}

	public boolean isCellEditable(int row, int col) {
		return true;
	}

	public Class<?> getColumnClass(int column) {
		// return getValueAt(0, column).getClass();

		// Class clazz = null;
		// switch (column) {
		// case 0:
		// clazz = String.class;
		// break;
		// case 1:
		// clazz = String.class;
		// break;
		// case 2:
		// clazz = String.class;
		// break;
		// }
		//  	
		// return clazz;

		return String.class;
	}
}
