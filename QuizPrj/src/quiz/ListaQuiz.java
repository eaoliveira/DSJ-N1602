package quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListaQuiz")
public class ListaQuiz extends HttpServlet {
	static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String ate18 = Utilitarios.getCookieValue(request, "ate18", "0");
		String ate26 = Utilitarios.getCookieValue(request, "ate26", "0");
		String ate35 = Utilitarios.getCookieValue(request, "ate35", "0");
		String ate99 = Utilitarios.getCookieValue(request, "ate99", "0");

		out.println("<html><head><title>Respostas do Quiz</title></head>");
		out.println("<body><table border=\"1\"><th>Qtd.</th><th>Resposta</th>");
		
		out.println("<tr><td>" + ate18 + "</td><td>at&eacute; 18</td></tr>");
		out.println("<tr><td>" + ate26 + "</td><td>de 19 at&eacute; 26</td></tr>");
		out.println("<tr><td>" + ate35 + "</td><td>de 27 at&eacute; 35</td></tr>");
		out.println("<tr><td>" + ate99 + "</td><td>acima de 35</td></tr>");
		out.println("</table>");

		out.print("<input type=\"button\" value=\"Voltar\"");
		out.println(" onclick=\"window.location.replace('quiz.html');\" >");
		out.println("</body>");

	}
}
