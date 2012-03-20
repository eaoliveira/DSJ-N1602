package api.jdbc.tabela;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


@SuppressWarnings("serial")
public class FoneTableDb extends AbstractTableModel {
  private Connection con = null;
  private Statement query = null;
  private ResultSet dados = null;

  public FoneTableDb() {
    super();
    try {
      this.con = 	DataSource.getConnection("api.jdbc.tabela.dataBase");
      query = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
          																								ResultSet.CONCUR_UPDATABLE);
      dados = query.executeQuery("select * from Fone");
    } catch(Exception ex) {
      System.err.println("SQL Erro: " + ex.getMessage());
      System.exit(-1);
    }
  }

  public void add(Fone f) {
    try {
    dados.moveToInsertRow();
    dados.updateString("tipo", f.getTipo().toString());
    dados.updateString("ddd", f.getDdd());
    dados.updateString("numero", f.getNumero());
    dados.insertRow();
    dados.beforeFirst();
    fireTableDataChanged();
    } catch(Exception ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro",
        JOptionPane.ERROR_MESSAGE);
    }
  }
  
  public int getColumnCount() {
    return 3;
  }

  public int getRowCount() {
    try {
      dados.last();
      return dados.getRow();
    } catch(Exception ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro",
        JOptionPane.ERROR_MESSAGE);
      return 0;
    }
  }

  public String getColumnName(int col) {
    switch(col) {
      case 0:
        return "Tipo";
      case 1:
        return "DDD";
      case 2:
        return "Numero";
      default:
        return null;
    }
  }

  public Object getValueAt(int row, int col) {
    try {
      dados.absolute(row+1);

      switch(col) {
        case 0:
          return dados.getString("tipo");
        case 1:
          return dados.getString("ddd");
        case 2:
          return dados.getString("numero");
        default:
          return null;
      }
    } catch(Exception ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro",
        JOptionPane.ERROR_MESSAGE);
      return null;
    }
  }

  public void setValueAt(Object value, int row, int col) {
    try {
      dados.absolute(row+1);

      switch(col) {
        case 0:
          dados.updateString("tipo", ((TipoFone)value).toString());
          break;
        case 1:
          dados.updateString("ddd", (String)value);
          break;
        case 2:
          dados.updateString("numero", (String)value);
          break;
        default:
          break;
      }
      dados.updateRow();
    } catch(Exception ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro",
        JOptionPane.ERROR_MESSAGE);
    }
  }

  public boolean isCellEditable(int row, int col) {
    return true;
  }
  
  public Class<?> getColumnClass(int column) {
    return getValueAt(0, column).getClass();
  }
}
