package api.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListaAluno {
	public static void main(String[] args) throws Exception {
		// Registrar o Driver JDBC na VM Java
		Class.forName("com.mysql.jdbc.Driver");

		// Inicia a conexao ao Banco  de Dados
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/escola" , "root", ""	);
			
		// Executar um SQL de consulta ao banco
		Statement sql  = con.createStatement();
		ResultSet resposta = sql.executeQuery("select * from aluno");
		
		// Apresenta o resultado da consulta SQL
		while(resposta.next()) { // enquanto houver registros não lidos
			// Le os campos do Resuldado da consulta SQL
			int id = resposta.getInt("idaluno");
			String nome =  resposta.getString("nome");
			String matricula = resposta.getString("matricula");
			
			// apresenta os valores na tela
			System.out.println("id: " + id +
					                         "\nNome: " + nome +
					                         "\nMatrícula: " + matricula);
		}
		
		// Fechar a conexao
		con.close();
	}
}
