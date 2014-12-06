package view;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EntityDao;
import bean.TurmaBean;

@WebServlet("/CarregaTurmas")
public class CarregaTurmas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private EntityDao dao;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
			request.getSession().setAttribute("turmas", new TurmaBean(dao.getTurmas()));
			
			response.sendRedirect("listaturma.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
