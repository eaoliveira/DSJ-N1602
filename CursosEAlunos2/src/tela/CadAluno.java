package tela;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Mensagem;
import dao.CursoDao;
import modelo.Aluno;
import modelo.Curso;

@WebServlet("/CadAluno")
public class CadAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private CursoDao dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// prepara a mensagem para o usuario
		Mensagem msg = new Mensagem();
		msg.setTitulo("Cadastro de Alunos");
		msg.setUrl("cadAluno.html");

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		int idcurso = Integer.parseInt(request.getParameter("curso"));

		Curso curso = dao.getCurso(idcurso);

		if (curso == null) {
			msg.setTexto("Problema: A Turma não está cadastrada");
		} else {

			Aluno obj = new Aluno();
			obj.setNome(nome);
			obj.setEmail(email);
			obj.setCurso(curso);

			curso.getAlunos().add(obj);

			dao.adiciona(obj);

			msg.setTexto("Aluno cadastrado com sucesso");
		}
		
		// salva a mensagem
		HttpSession ses = request.getSession();
		ses.setAttribute("msg", msg);
		// envia a mensagem
		response.sendRedirect("resultPage.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
