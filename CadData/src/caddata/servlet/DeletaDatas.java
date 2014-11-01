package caddata.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import caddata.dao.GerenteDeDados;

@WebServlet("/DeletaDatas")
public class DeletaDatas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			String[] ids = request.getParameterValues("del");
		
			GerenteDeDados dao = GerenteDeDados.getInstance();

			if(ids != null)
				for (String id : ids)
					dao.apagaData(Integer.parseInt(id));
			
			response.sendRedirect("mostraDatas.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
