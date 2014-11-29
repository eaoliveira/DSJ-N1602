package sp.senai.org.br.view;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sp.senai.org.br.dao.CadastraAluno;
import sp.senai.org.br.dao.CadastraTurma;
import sp.senai.org.br.model.Aluno;
import sp.senai.org.br.model.Turma;
@WebServlet("/Cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CadastraTurma daoTurma;
	private CadastraAluno daoAluno;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Obtem os parâmetros da requisição WEB
		try {
			DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
			df.setLenient(false);

			String titulo = request.getParameter("titulo");
			String descricao = request.getParameter("descricao");
			String inicio = request.getParameter("inicio");
			String numHoras = request.getParameter("numHoras");

			Turma turma = new Turma();
			turma.setTitulo(titulo);
			turma.setDescricao(descricao);
			turma.setInicio(df.parse(inicio));
			turma.setNumHoras(Integer.parseInt(numHoras));
			daoTurma.salvar(turma);
			
			
		    String  nome= request.getParameter("nome");
		    String email= request.getParameter("email");
		    String matricula = request.getParameter("matricula");
		    
		    Aluno aluno = new Aluno();
		    aluno.setNome(nome);
		    aluno.setEmail(email);
		    aluno.setMatricula(Integer.parseInt(matricula));
		    daoAluno.salvar(aluno);
		    
		} catch (ParseException ex) {
			
			System.out.println("Data invalida");

		}
	}
}
