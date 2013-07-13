package servlets.cookies;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servlet that processes a registration form containing a user's first name,
 * last name, and email address. If all the values are present, the servlet
 * displays the values. If any of the values are missing, the input form is
 * redisplayed. Either way, the values are put into cookies so that the input
 * form can use the previous values.
 * <P>
 * Taken from Core Servlets and JavaServer Pages 2nd Edition from Prentice Hall
 * and Sun Microsystems Press, http://www.coreservlets.com/. &copy; 2003 Marty
 * Hall; may be freely used or adapted.
 */

@SuppressWarnings("serial")
public class RegistrationServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		boolean isMissingValue = false;
		
		String firstName = request.getParameter("firstName");
		if (isMissing(firstName)) {
			firstName = "Missing first name";
			isMissingValue = true;
		}
		
		String lastName = request.getParameter("lastName");
		if (isMissing(lastName)) {
			lastName = "Missing last name";
			isMissingValue = true;
		}
		
		String emailAddress = request.getParameter("emailAddress");
		if (isMissing(emailAddress)) {
			emailAddress = "Missing email address";
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
			String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
					+ "Transitional//EN\">\n";
			String title = "Obrigado por efetuar seu registro";
			out.println(docType + 
					"<HTML>\n" +
					"<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" + 
					"<BODY BGCOLOR=\"#FDF5E6\">\n" +
					"<CENTER>\n" + 
					"<H1 ALIGN>" + title + "</H1>\n" +
					"<UL>\n" + 
					"  <LI><B>Nome</B>: " + firstName + "\n" +
					"  <LI><B>Sobrenome</B>: " + lastName + "\n" +
					"  <LI><B>E-mail</B>: " + emailAddress + "\n" + 
					"</UL>\n" +
					"<input type=\"button\" value=\"Voltar\" onclick=\"window.history.back(-1);\" >" +
					"</CENTER></BODY></HTML>");
		}
	}

	/** Determines if value is null or empty. */

	private boolean isMissing(String param) {
		return ((param == null) || (param.trim().equals("")));
	}
}
