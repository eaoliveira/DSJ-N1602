package servlets.cookies;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/jsps/RegistrationForm")
@SuppressWarnings("serial")
public class RegistrationForm extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	
    response.setContentType("text/html");
    
    PrintWriter out = response.getWriter();
    
    String actionURL = "RegistrationServlet";
    
    String firstName = CookieUtilities.getCookieValue(request, "firstName", "");
    String lastName = CookieUtilities.getCookieValue(request, "lastName", "");
    String emailAddress = CookieUtilities.getCookieValue(request, "emailAddress","");   
    
    String docType = "<!DOCTYPE html>\n";
    String title = "Fa&ccedil;a seu Registro";
    out.println(docType +"<html>\n" +
				"<head>\n<title>" + title	+ "</title>\n" +
				"<meta charset=\"UTF-8\">\n" +
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"../style/paginas.css\">\n" + 
				"</head>\n" + 
				"<body>\n" +
			    "<h2>" + title + "</h2>\n<hr/>\n" + 
       			"<form action=\"" + actionURL + "\">\n" +
       			"<p>Nome: <input type=\"text\" name=\"firstName\" value=\"" + firstName + "\"></p>\n" +
       			"<p>Sobrenome:  <input type=\"text\" name=\"lastName\" value=\"" + lastName + "\"></p>\n" +
       			"<p>E-mail:  <input type=\"text\" name=\"emailAddress\" value=\"" + emailAddress + "\"></p>\n" +
       			"<p><input type=\"submit\" value=\"Registrar\">" +
				"<input type=\"button\" value=\"Voltar\" onclick=\"window.location='cookie.html'\"></p>\n" +
    		  	"</form></body>\n</html>");
  }
}
