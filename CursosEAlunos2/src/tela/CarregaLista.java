package tela;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CursoDao;

@WebServlet("/cadAluno.html")
public class CarregaLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private CursoDao dao;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("cursos", dao.getCursos());
		request.getRequestDispatcher("cadAluno.jsp").forward(request, response);
	}
}
