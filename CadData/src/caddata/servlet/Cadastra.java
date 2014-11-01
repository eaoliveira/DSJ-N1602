package caddata.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import caddata.bean.Mensagem;
import caddata.dao.GerenteDeDados;

@WebServlet("/Cadastra")
public class Cadastra extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String valor = request.getParameter("data");

			DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
			df.setLenient(false);
			Date data = df.parse(valor);
			
			GerenteDeDados dao = GerenteDeDados.getInstance();
			dao.gravaData(data);
			
			request.getSession().setAttribute("msg", 
					new Mensagem("A data foi gravada", "CarregaDatas"));
			response.sendRedirect("resultado.jsp");
		} catch (ParseException e) {
			request.getSession().setAttribute("msg", 
					new Mensagem("Data Inválida", "index.html"));
			response.sendRedirect("resultado.jsp");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
