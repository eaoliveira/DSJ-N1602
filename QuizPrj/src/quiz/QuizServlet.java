package quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String cookieName = request.getParameter("idade");

		out.println("<html><head><title>Quiz</title></head>");
		out.println("<body>");

		if (cookieName == null) {
			out.println("<h2>N&atilde;o foi selecionado nenhum &iacute;tem!</h2>");
		} else {
			String valor = Utilitarios.getCookieValue(request, cookieName, "0");
			int num = Integer.parseInt(valor) + 1;
			Cookie quiz = new Cookie(cookieName, String.valueOf(num));

			response.addCookie(quiz);
			out.println("<h2>Obrigado por responder nosso Quiz!</h2>");
			out.print("<input type=\"button\" value=\"Lista Respostas\"");
			out.println(" onclick=\"window.location.replace('ListaQuiz');\" >&nbsp;");
		}

		out.print("<input type=\"button\" value=\"Voltar\"");
		out.println(" onclick=\"window.history.back(-1);\" >");
		out.println("</body>");
	}
}
