package quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import servlets.libs.WebUtilities;


public class Utilitarios {
	public static String getCookieValue(HttpServletRequest request,
			String cookieName, String valorPadrao) {
	      Cookie[] cookies = request.getCookies();
	      
	      String resposta = valorPadrao;
	      
	      if(cookies != null) {
	        for(int i = 0;i < cookies.length;i++) {
	          Cookie cookie = cookies[i];
	          String nome = cookie.getName();
	          
	          if(nome.equals(cookieName)) {
	          	resposta = cookie.getValue();
	          	break;
	          }
	        }
	      }
	      return resposta;
	}
	
	public static void salvaQuiz(HttpServlet servlet, PrintWriter out, String msg) throws IOException {
		String header = WebUtilities.loadFile(servlet, "/resources/header.html");
		String footer = WebUtilities.loadFile(servlet, "/resources/footer.html");

		String body = "<h2>" + msg + "</h2>" +
				"<form id='form1' action='index.html'>"+
					"<div data-row>" +
						"<input type='submit' id='submit' value='Voltar'>";
		if(msg.startsWith("Obrigado")) {
				body +=	"<input type='submit' id='submitL' value='Lista Respostas'" +
								"formaction='ListaQuiz'>";
		}
		body +=		"</div>" +
				"</form>";

		out.println(header + body +	footer);
	}
}
