package Sever2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HTML/ListaQuiz")
public class ListaQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String quiz1 = CookieUtilities.getCookieValue(request, "quiz1", "0");
			String quiz2 = CookieUtilities.getCookieValue(request, "quiz2", "0");
			String quiz3 = CookieUtilities.getCookieValue(request, "quiz3", "0");
			String quiz4 = CookieUtilities.getCookieValue(request, "quiz4", "0");
		
		  PrintWriter out = response.getWriter();
	      out.print(montaTela("<h3>Dados Digitados<h3>\n" +
	    	  "<p>Ate 18 " + quiz1 + "</p>\n" +
	          "<p>Entre 19 e 26 " + quiz2 + "</p>\n" +
	          "<p>Entre 27 e 35 " + quiz3 + "</p>\n" +
	          "<p>Acima de 35 " + quiz4 + "</p>\n" +
	          "<p>\n" +
	          "<input type=\"button\" value=\"Voltar\"\n" +
	    	  "onclick=\"window.location.replace('quiz.html');\"></p>"));
	}
	public String montaTela(String msg) {
	    return 
	    		"<!DOCTYPE html>\n" +
	    		"<html>\n" +
	        "<head>\n" +
	        "<meta charset=\"UTF-8\">\n" +
	        "<title>Cadastro</title>\n" +
			"<link rel=\"stylesheet\" type=\"text/css\" href=\"../style/paginas.css\">\n" + 
	        "</head>\n" +
	        "<body>\n" +
	        "<h2>Quiz Amigo</h2>" +
	        "<h2>Qual Sua Idade ?</h2>" + 
	        
	        msg + "\n" +
	        	"</body>\n" +
	        	"</html>";
	  }
}
