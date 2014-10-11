package cadFoneDerby;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class FoneModel extends AbstractTableModel {
	private GerenteDeDados dados;
	private Map<Integer, Integer> ids;

	public FoneModel(GerenteDeDados dados) throws GerenteException {
		this.dados = dados;
		inicializaIds();
	}

	public void adiciona(Fone obj) throws GerenteException {
		dados.salva(obj);
		inicializaIds();
		fireTableDataChanged();
	}

	public void remove(int linha) throws GerenteException {
		dados.remove(ids.get(linha));
		inicializaIds();
		fireTableDataChanged();
	}

	private void inicializaIds() throws GerenteException {
		List<Fone> lista = dados.listaTodos();
		ids = new HashMap<>();

		for (int i = 0; i < lista.size(); i++) {
			Fone obj = lista.get(i);
			ids.put(i, obj.getId());
		}
	}

	// Informa quantas linhas a tabela deve ter
	@Override
	public int getRowCount() {
		return ids.size();
	}

	// Informa quantas colunas a tabela deve ter
	@Override
	public int getColumnCount() {
		return 3;
	}

	// Informa o nome de uma determinada coluna
	@Override
	public String getColumnName(int col) {
		String nome = "";

		switch (col) {
		case 0:
			nome = "DDD";
			break;
		case 1:
			nome = "Número";
			break;
		case 2:
			nome = "Tipo";
			break;
		}
		return nome;
	}

	// Devolve o conte�do de uma coluna numa determinada linha
	@Override
	public Object getValueAt(int lin, int col) {
		Object valor = null;
		try {
			Fone obj = dados.localiza(ids.get(lin));
			
			switch (col) {
			case 0:
				valor = obj.getDdd();
				break;
			case 1:
				valor = obj.getNumero();
				break;
			case 2:
				valor = obj.getTipo();
				break;
			}
		} catch (GerenteException ex) {
			ex.printStackTrace();
		}
		return valor;
	}

	// Armazena o conte�do em uma colula numa determinada linha
	@Override
	public void setValueAt(Object valor, int lin, int col) {
		try {
			Fone obj = dados.localiza(ids.get(lin));
			
			switch (col) {
			case 0:
				obj.setDdd((String)valor);
				break;
			case 1:
				obj.setNumero((String)valor);
				break;
			case 2:
				obj.setTipo((TipoFone)valor);
				break;
			}
			
			dados.salva(obj);
		} catch(GerenteException ex) {
			ex.printStackTrace();
		}
	}

	// Informa se uma coluna numa determinada linha � pass�vel de edi��o
	@Override
	public boolean isCellEditable(int lin, int col) {
		return true;
	}
}
