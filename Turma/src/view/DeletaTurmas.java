package view;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EntityDao;

@WebServlet("/DeletaTurmas")
public class DeletaTurmas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private EntityDao dao;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			String[] ids = request.getParameterValues("del");

			if(ids != null)
				for (String id : ids)
					dao.apagaData(Integer.parseInt(id));
			
			response.sendRedirect("CarregaTurmas");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
