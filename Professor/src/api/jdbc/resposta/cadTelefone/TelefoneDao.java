package api.jdbc.resposta.cadTelefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import api.jdbc.resposta.acessoDb.DbException;
import api.jdbc.resposta.acessoDb.DbFactory;

public class TelefoneDao {
	private Connection con;
	private PreparedStatement sql;

	public TelefoneDao() throws DbException {
		con = DbFactory.createDb().getConnection();
		try {
			sql = con
					.prepareStatement("insert into fone (ddd, numero, tipo) values (?,?,?)");
		} catch (SQLException ex) {
			throw new DbException("Problemas na preparação dos Srcipts SQL");
		}
	}

	public void salva(Fone obj) throws DbException {
		try {
			sql.setString(1, obj.getDdd());
			sql.setString(2, obj.getNumero());
			sql.setString(3, obj.getTipo().toString());
			sql.execute();
		} catch (SQLException e) {
			throw new DbException("Falha na gravação dos Dados");
		}
	}

	public List<Fone> getFones() throws DbException {
		try {
			List<Fone> lista = new ArrayList<>();
			Statement sql = con.createStatement();
			ResultSet resposta = sql.executeQuery("select * from fone");

			while (resposta.next()) {
				Fone f = new Fone();
				f.setDdd(resposta.getString("ddd"));
				f.setNumero(resposta.getString("numero"));
				f.setTipo(TipoFone.valueOf(resposta.getString("tipo")));
				lista.add(f);
			}
			return lista;
		} catch (SQLException ex) {
			throw new DbException("Falha da obtenção dos Dados");
		}
	}
}
