package servlets.cookies;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import servlets.libs.WebUtilities;

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

		String header = WebUtilities.loadFile(this, "/resources/header.html").replace("TITULO", "Contador de Acessos");
		String footer = WebUtilities.loadFile(this, "/resources/footer.html");

		PrintWriter out = response.getWriter();

		out.println(header + "<h2>Você acessou " + count + " vezes esta Página.</h3>" + footer);
	}
}
