package tela;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpresaDao;
import bean.Empresas;

@WebServlet("/index.html")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	private EmpresaDao dao;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// obter a lista de cursos
		Empresas obj = dao.getEmpresas();
		// salvar os cursos na sessao http
		request.getSession().setAttribute("emp", obj);
		// redirecionar para o jsp que monta a lista
		response.sendRedirect("lista.jsp");
	}
}
