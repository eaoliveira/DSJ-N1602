package tela;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Cursos;
import dao.CursoDao;

@WebServlet("/index.html")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// obter a lista de cursos
		Cursos obj = CursoDao.getInstance().getCursos();
		// salvar os cursos na sessao http
		request.getSession().setAttribute("cursos", obj);
		// redirecionar para o jsp que monta a lista
		response.sendRedirect("lista.jsp");
	}
}
