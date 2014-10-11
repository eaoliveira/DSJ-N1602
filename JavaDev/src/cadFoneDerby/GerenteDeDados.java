package cadFoneDerby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GerenteDeDados {
	private Connection con;
	private  PreparedStatement insereFone;
	private  PreparedStatement localizaFone;
	private  PreparedStatement atualizaFone;
	private  PreparedStatement removeFone;
	private  PreparedStatement listaFone;
	
	// Registra o driver JDBC, Conecta ao Banco de Dados e 
	// Prepara as declarações SQL para uso
	public GerenteDeDados() throws GerenteException {
		try {
			// Conecta ao banco de dados
			con = DriverManager.getConnection(
					"jdbc:derby:Cadastro;create=true", "sys", "admin");
			
			try {
				con.createStatement().execute("Select count(*) from cadastro.telefone");
			} catch(SQLException ex) {
				Statement ddl = con.createStatement();
				ddl.execute("Create Table cadastro.telefone (idtelefone Int Primary KEY "
						+ "not null Generated Always as Identity, "
						+ "ddd varchar(3), "
						+ "numero varchar(10), "
						+ "tipo varchar(25)"
						+ ")");
			}
			
			// Prepara as declarações SQL para uso
			insereFone = con.prepareStatement("insert into cadastro.telefone (ddd, numero, tipo) values (?, ?, ?)");
			atualizaFone = con.prepareStatement("update cadastro.telefone set ddd=?, numero=?, tipo=? where idtelefone=?");
			removeFone = con.prepareStatement("delete from cadastro.telefone where idtelefone=?");
			localizaFone = con.prepareStatement("select * from cadastro.telefone where idtelefone=?");
			listaFone = con.prepareStatement("select * from cadastro.telefone");
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new GerenteException("Houve problema na conexão ao banco de dados");
		}
	}
	
	// Insere um novo registro ou Atualiza um registro existente
	public void salva(Fone obj) throws GerenteException {	
		String acao = "";
		try {
			if(obj.getId() == null) { // Insere um novo registro
				acao = "inserção";
				insereFone.setString(1, obj.getDdd());
				insereFone.setString(2, obj.getNumero());
				insereFone.setString(3, obj.getTipo().toString());
				insereFone.execute();
			} else { // Atualiza um registro existente
				acao = "atualização";
				atualizaFone.setString(1, obj.getDdd());
				atualizaFone.setString(2, obj.getNumero());
				atualizaFone.setString(3, obj.getTipo().toString());
				atualizaFone.setInt(4, obj.getId());
				atualizaFone.execute();
			}
		} catch (SQLException ex) {
			throw new GerenteException("Houve problema na " + acao + " do registro");
		}
	}
	
	// Cria um objeto Telefone extraindo os dados do Resultado da consulta SQL
	private Fone criaObjeto(ResultSet resultado) throws SQLException {
		Fone obj = new Fone();
		obj.setId(resultado.getInt("idtelefone"));
		obj.setDdd(resultado.getString("ddd"));
		obj.setNumero(resultado.getString("numero"));
		obj.setTipo(TipoFone.valueOf(resultado.getString("tipo")));
		return obj;
	}
	
	// Retorna um Telefone do banco de dados a partir de um determinado ID
	public Fone localiza(int id) throws GerenteException {
		try {
			localizaFone.setInt(1, id);
			ResultSet resposta = localizaFone.executeQuery();
			
			Fone obj = null;
			if(resposta.next()) {
				obj = criaObjeto(resposta);
			}
			
			return obj;
		} catch(SQLException ex) {
			throw new GerenteException("Erro na consulta do registro");
		}
	}
	
	// Retorna a lista de todos os Telefones existentes no banco de dados
	public List<Fone> listaTodos() throws GerenteException {
		try {			
			List<Fone> lista = new ArrayList<>();
			ResultSet resposta = listaFone.executeQuery();

			while(resposta.next()) {
				Fone obj = criaObjeto(resposta);
				lista.add(obj);
			}
			
			return lista;
		} catch(SQLException ex) {
			throw new GerenteException("Erro na consulta dos registros");
		}
	}
	
	// Remove um Telefone do banco de dados a partir de um determinado ID
	public void remove(int id) throws GerenteException {
		try {
			removeFone.setInt(1, id);
			removeFone.execute();
		} catch (SQLException ex) {
			throw new GerenteException("Erro na exclusão do registro");
		}
	}
	
	// Finaliza a conexão com o banco de dados
	public void fecha() {
		try {
			con.close();
		} catch(SQLException ex) {
		}
	}
}
