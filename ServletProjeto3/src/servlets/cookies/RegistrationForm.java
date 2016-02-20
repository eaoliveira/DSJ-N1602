package servlets.cookies;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import servlets.libs.WebUtilities;

@WebServlet("/jsps/RegistrationForm")
@SuppressWarnings("serial")
public class RegistrationForm extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	
    response.setContentType("text/html");

	String header = WebUtilities.loadFile(this, "/resources/header.html").replace("TITULO", "Formulário de Registro");
	String footer = WebUtilities.loadFile(this, "/resources/footer.html");
    
    PrintWriter out = response.getWriter();
    
    String actionURL = "RegistrationServlet";
    
    String nome = CookieUtilities.getCookieValue(request, "nome", "");
    String sobrenome = CookieUtilities.getCookieValue(request, "sobrenome", "");
    String email = CookieUtilities.getCookieValue(request, "email","");   
    
    out.println(header +
       			"<form id='form1' action='" + actionURL + "' method='post'><fieldset>" +
       				"<div>" +
       					"<label for='nome'>Nome</label>" +
       					"<input id='nome' type='text' name='nome' placeholder='" + nome + "' " +
       							"required aria-required='true'>" +
       				"</div>" +
       				"<div>" +
       					"<label for='sobrenome'>Sobrenome</label>" +
       					"<input id='sobrenome' type='text' name='sobrenome' placeholder='" + sobrenome + "' " +
       							"required aria-required='true'>" +
       				"</div>" +
       				"<div>" +
       					"<label for='email'>E-mail</label>" +
       					"<input id='email' type='text' name='email' placeholder='" + email + "' " +
       							"required aria-required='true'>" +
       				"</div>" +
       				"<div>" +
       					"<input type='submit' id='submit' value='Registrar'>" +
       				"</div>" +
       			"</fieldset></form>" +
       			footer);
  }
}
