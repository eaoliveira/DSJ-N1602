package api.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class InserirAluno {
	public static void main(String[] args) throws Exception {
		// Registrar o Driver JDBC na VM Java
		Class.forName("com.mysql.jdbc.Driver");

		// Inicia a conexão ao Banco de Dados
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/escola", "root", "");

		// Preparar uma instrução SQL para a inserção de dados de Aluno
		PreparedStatement ins = con
				.prepareStatement("insert into aluno (nome, matricula) values (?,?)");

		// Insere dados na tabela Aluno
		for (int i = 0; i < 3; i++) {
			String nome = JOptionPane.showInputDialog("Informe o nome");
			String matricula = JOptionPane.showInputDialog("Informe a matricula");

			ins.setString(1, nome);
			ins.setString(2, matricula);
			ins.execute();
		}

		// Fechar a conexão
		con.close();
	}
}
