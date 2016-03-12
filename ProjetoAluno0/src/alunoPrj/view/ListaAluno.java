package alunoPrj.view;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alunoPrj.dao.AlunoDao;

@SuppressWarnings("serial")
@WebServlet("/ListaAluno")
public class ListaAluno extends HttpServlet {
	@EJB
	private AlunoDao dao;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("alunos", dao.listAlunos());
		request.getRequestDispatcher("listaaluno.jsp").forward(request, response);
	}
}
