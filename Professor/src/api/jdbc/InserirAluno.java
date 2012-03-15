package api.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class InserirAluno {
	public static void main(String[] args) throws Exception {
		// Registrar o Driver JDBC na VM Java
		Class.forName("com.mysql.jdbc.Driver");

		// Inicia a conexao ao Banco de Dados
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/escola", "root", "");

		// Preparar uma instrucao SQL para a inserção de dados de Aluno
		PreparedStatement ins = con
				.prepareStatement("insert into aluno (nome, matricula) values (?,?)");

		for (int i = 0; i < 3; i++) {
			// Obtem do usuario os dados a serem inseridos no Banco de Dados
			// pode ser obtido tambem atraves de um JFrame com JTextFields
			String nome = JOptionPane.showInputDialog("Informe o nome");
			String matricula = JOptionPane.showInputDialog("Informe a matricula");

			// Insere os dados capturados no comando SQL
			ins.setString(1, nome);
			ins.setString(2, matricula);
			
			// executa o comando SQL no Banco de Dados
			ins.execute();
		}
		
		// Fechar a conexão
		con.close();
	}
}
