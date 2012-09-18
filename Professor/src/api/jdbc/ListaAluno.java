package api.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListaAluno {
	public static void main(String[] args) throws Exception {
		// Registrar o Driver JDBC na VM Java
		Class.forName("com.mysql.jdbc.Driver");

		// Inicia a conexão ao Banco  de Dados
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/escola" , "root", ""	);
			
		// Executar um SQL de consulta ao banco
		Statement sql  = con.createStatement();
		ResultSet resposta = sql.executeQuery("select * from aluno");
		
		// Apresenta o resultado da consulta SQL
		while(resposta.next()) {
			System.out.println("id: " + resposta.getInt("idaluno") +
					                         "\nNome: " + resposta.getString("nome") +
					                         "\nMatrícula: " + resposta.getString("matricula"));
		}
		
		// Fechar a conexão
		con.close();
	}
}
