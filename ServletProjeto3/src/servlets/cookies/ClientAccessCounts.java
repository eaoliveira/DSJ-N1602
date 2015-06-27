package servlets.cookies;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/jsps/ClientAccessCounts")
@SuppressWarnings("serial")
public class ClientAccessCounts extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String countString = CookieUtilities.getCookieValue(request, "accessCount", "1");
		
		int count = 1;
		try {
			count = Integer.parseInt(countString);
		} catch (NumberFormatException nfe) {
		}
		
		LongLivedCookie c = new LongLivedCookie("accessCount",String.valueOf(count + 1));
		response.addCookie(c);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Servlet de contagem de acessos";
		String docType = "<!DOCTYPE html>\n";
		out.println(docType +"<html>\n" +
				"<head>\n<title>" + title	+ "</title>\n" +
				"<meta charset=\"UTF-8\">\n" +
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"../style/paginas.css\">\n" + 
				"</head>\n" + 
				"<body>\n" +
			    "<h2>" + title + "</h2>\n<hr/>\n" +
				"<h3>Voc&ecirc; acessou " + count + " vezes esta P&aacute;gina.</h3>\n" +
				"<p><input type=\"button\" value=\"Voltar\" onclick=\"window.location='cookie.html'\"></p>\n" +
    		  	"</body>\n</html>");
	}
}
