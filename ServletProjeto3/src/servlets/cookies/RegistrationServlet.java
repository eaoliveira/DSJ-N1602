package servlets.cookies;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/jsps/RegistrationServlet")
@SuppressWarnings("serial")
public class RegistrationServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		boolean isMissingValue = false;
		
		String firstName = request.getParameter("firstName");
		if (isMissing(firstName)) {
			firstName = "Falta o primeiro nome";
			isMissingValue = true;
		}
		
		String lastName = request.getParameter("lastName");
		if (isMissing(lastName)) {
			lastName = "Falta o sobrenome";
			isMissingValue = true;
		}
		
		String emailAddress = request.getParameter("emailAddress");
		if (isMissing(emailAddress)) {
			emailAddress = "Falta o e-mail";
			isMissingValue = true;
		}
		
		String formAddress = "RegistrationForm";
		if (isMissingValue) {
			response.sendRedirect(formAddress);
		} else {
			Cookie c1 = new LongLivedCookie("firstName", firstName);
			response.addCookie(c1);
			Cookie c2 = new LongLivedCookie("lastName", lastName);
			response.addCookie(c2);
			Cookie c3 = new LongLivedCookie("emailAddress", emailAddress);
			response.addCookie(c3);

			PrintWriter out = response.getWriter();
			String docType = "<!DOCTYPE html>\n";
			String title = "Obrigado por efetuar seu registro";
			out.println(docType + 
					"<html>\n" +
					"<head>\n<title>" + title	+ "</title>\n" +
					"<meta charset=\"UTF-8\">\n" +
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"../style/paginas.css\">\n" + 
					"</head>\n" + 
					"<body>\n" +
				    "<h2>" + title + "</h2>\n<hr/>\n" + 
					"<ul>\n" + 
					"  <li><b>Nome</b>: " + firstName + "\n" +
					"  <li><b>Sobrenome</b>: " + lastName + "\n" +
					"  <li><b>E-mail</b>: " + emailAddress + "\n" + 
					"</ul>\n" +
					"<input type=\"button\" value=\"Voltar\" onclick=\"window.location='cookie.html'\">\n" +
					"</body>\n</html>");
		}
	}

	private boolean isMissing(String param) {
		return ((param == null) || (param.trim().equals("")));
	}
}
