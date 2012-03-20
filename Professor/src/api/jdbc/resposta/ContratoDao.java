package api.jdbc.resposta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// Singleton
public class ContratoDao {
	private static ContratoDao thisInstance;
	private Connection con = null;
	private Statement query = null;
	private ResultSet dados = null;

	private ContratoDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost/contratos",	"root", "");
			query = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					                                               ResultSet.CONCUR_UPDATABLE);
			dados = query.executeQuery("select * from contrato");
		} catch (Exception ex) {
			System.err.println("SQL Erro: " + ex.getMessage());
			System.exit(-1);
		}
	}

	public static ContratoDao getInstance() {
		if (thisInstance == null)
			thisInstance = new ContratoDao();

		return thisInstance;
	}
	
	public void add(Contrato reg) throws Exception {
		dados.moveToInsertRow();
		dados.updateString("numero", reg.getNumero());
		dados.updateString("descricao", reg.getDescricao());
		dados.insertRow();
		dados.beforeFirst();
	}

	public int count() {
		try {
			dados.last();
			return dados.getRow();
		} catch(Exception ex) {
			return 0;
		}
	}

	public void del(int row) {
		try {
  		dados.absolute(row + 1);
  		dados.deleteRow();
  		dados.beforeFirst();
		} catch(Exception ex) {
		}
	}

	public void del(Contrato contr) {
		try {
			dados.beforeFirst();
			while(dados.next()) {
				if(contr.equals(new Contrato(dados.getString("numero"),  dados.getString("descricao")))) {
		  		dados.deleteRow();
		  		dados.beforeFirst();
					break;
				}
			}
		} catch(Exception ex) {
		}
	}

	public Contrato get(int row) {
		try {
			dados.absolute(row + 1);
			Contrato contr = new Contrato();
			contr.setIdContrato(dados.getInt("idContrato"));
			contr.setNumero(dados.getString("numero"));
			contr.setDescricao(dados.getString("descricao"));
			return  contr;
		} catch(Exception ex) {
			return null;
		}
	}

	public Contrato find(String numero) {
		try {
			dados.beforeFirst();
			Contrato contr = null;
			while(dados.next()) {
				if(numero.equals(dados.getString("numero"))) {
					contr = new Contrato();
					contr.setIdContrato(dados.getInt("idContrato"));
					contr.setNumero(dados.getString("numero"));
					contr.setDescricao(dados.getString("descricao"));
					break;
				}
			}
			return contr;
		} catch(Exception ex) {
			return null;
		}
	}
}

