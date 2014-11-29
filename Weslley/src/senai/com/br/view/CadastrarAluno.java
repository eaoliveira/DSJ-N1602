package senai.com.br.view;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import senai.com.br.bean.Aluno;
import senai.com.br.dao.AlunoDAO;
import senai.com.br.dao.TurmasDAO;

/**
 * Servlet implementation class Cadastrar
 */
@WebServlet("/cadastroAluno")
public class CadastrarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private AlunoDAO daoAluno;
	@EJB
	private TurmasDAO daoTurma;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarAluno() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Aluno aluno = new Aluno();
		aluno.setNome(request.getParameter("nome"));
		aluno.setEmail(request.getParameter("email"));
		aluno.setMatricula(Integer.parseInt(request.getParameter("matricula")));			
		aluno.setTurma(daoTurma.getTurma(2));
		
		System.out.println(aluno);
		
		daoAluno.salvar(aluno);
		response.sendRedirect("mensagemAlunoCadastrado.html");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
