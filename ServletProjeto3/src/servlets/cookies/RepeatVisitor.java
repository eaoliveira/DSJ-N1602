package servlets.cookies;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/jsps/RepeatVisitor")
@SuppressWarnings("serial")
public class RepeatVisitor extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean newbie = true;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if ((c.getName().equals("repeatVisitor")) &&
				// Não posso omitir o teste e tratar o nome do cookie como um flag (indicador)
						(c.getValue().equals("yes"))) {
					newbie = false;
					break;
				}
			}
		}
		
		String title;
		if (newbie) {
			Cookie returnVisitorCookie = new Cookie("repeatVisitor", "yes");
			returnVisitorCookie.setMaxAge(60 * 60 * 24 * 365); // 1 ano
			
			response.addCookie(returnVisitorCookie);
			title = "Bem Vindo a bordo";
		} else {
			title = "Obrigado por retornar";
		}
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String docType = "<!DOCTYPE html>\n";
		out.println(docType + 
				"<html>\n" +
				"<head>\n<title>" + title	+ "</title>\n" +
				"<meta charset=\"UTF-8\">\n" +
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"../style/paginas.css\">\n" + 
				"</head>\n" + 
				"<body>\n" +
			    "<h2>" + title + "</h2>\n<hr/>\n" + 
				"<input type=\"button\" value=\"Voltar\" onclick=\"window.location='cookie.html'\">\n" +
				"</body>\n</html>");
	}
}
