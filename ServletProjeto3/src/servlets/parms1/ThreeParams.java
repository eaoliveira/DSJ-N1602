package servlets.parms1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsps/ThreeParams")
@SuppressWarnings("serial")
public class ThreeParams extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String title = "Lendo Tr&ecirc;s Par&acirc;metros";
		String docType = "<!DOCTYPE html>\n";
		
		out.println(docType + 
				"<html>\n" +
				"<head>\n<title>" + title	+ "</title>\n" +
				"<meta charset=\"UTF-8\">\n" +
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"../style/paginas.css\">\n" + 
				"</head>\n" + 
				"<body>\n" +
			    "<h2>" + title + "</h2>\n<hr/>\n" + 
				"<ul>\n" +
				"  <li><b>param1</b>: " + request.getParameter("param1") + "\n" + 
				"  <li><b>param2</b>: " + request.getParameter("param2") + "\n" +
				"  <li><b>param3</b>: " + request.getParameter("param3") + "\n" + 
				"</ul>\n" + 
				"<input type=\"button\" value=\"Voltar\" onclick=\"window.location='ThreeParamsForm.html'\">\n" +
				"</body>\n</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
