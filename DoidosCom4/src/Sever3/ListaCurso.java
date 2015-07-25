package Sever3;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Sever3.Gerente;
import Sever3.Cursos;

@WebServlet("/index.html")
public class ListaCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Cursos> lista = Gerente.getInstance().getLista();
		request.getSession().setAttribute("curso", lista);
		request.getRequestDispatcher("ListaCurso.jsp").forward(request, response);
	}
}