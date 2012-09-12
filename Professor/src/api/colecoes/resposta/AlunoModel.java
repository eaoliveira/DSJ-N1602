package api.colecoes.resposta;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


@SuppressWarnings("serial")
public class AlunoModel extends AbstractTableModel {
  private List<Aluno> lista;

  public AlunoModel() {
    super();
    this.lista = new ArrayList<Aluno>();
  }
  
  public void add(Aluno o) {
  	lista.add(o);
  	fireTableDataChanged();
  }
  
  public void del(int row) {
  	lista.remove(row);
  	fireTableDataChanged();
  }
  
  public int getColumnCount() { return 2; }

  public int getRowCount() { 
    if(lista == null)
      return 0;
    else
      return lista.size(); 
    }

  public String getColumnName(int col) {
    switch (col) {
      case 0:
        return "Nome";
      case 1:
        return "Matricula";
      default:
        return null;
    }
  }
  
  public Object getValueAt(int row, int col) {
  	Aluno o = lista.get(row);
    switch (col) {
      case 0:
        return o.getNome();
      case 1:
        return o.getMatricula();
      default:
        return null;
    }
  }
  
  public void	setValueAt(Object value, int row, int col) {
  	Aluno f = lista.get(row);
  	
      switch (col) {
        case 0:
          f.setNome((String)value);
          break;
        case 1:
          f.setMatricula((String)value);
          break;
        default:
          break;
      }
  }
  
  public boolean isCellEditable(int row, int col) {
    return true;
  }
  
  public Class<?> getColumnClass(int column) {
  	return String.class;
  }
}  

