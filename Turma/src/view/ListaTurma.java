package view;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EntityDao;

@WebServlet("/cadaluno.html")
public class ListaTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private EntityDao dao;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("turmas", dao.getTurmas());
		request.getRequestDispatcher("cadaluno.jsp").forward(request, response);
		}
}
