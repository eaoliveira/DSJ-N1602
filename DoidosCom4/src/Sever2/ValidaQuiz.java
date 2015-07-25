package Sever2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ValidaQuiz")
public class ValidaQuiz extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String quiz = request.getParameter("quiz");
		PrintWriter out = response.getWriter();

		if (quiz.isEmpty()) {
			out.print("</head><body><h3>Não exitem respostas para esse Quiz!</h3>" 
					 + "<input type=\"button\" value=\"Voltar\"  onclick=\"window.history.back(-1);\">"
					 + "</body></html>"
					);
		} else {
			out.print("<p>Obrigado por responder o nosso Quiz!\n"
					+ "<br><br>\n"
					+ "<input type=\"button\" value=\"Voltar\"  onclick=\"window.history.back(-1);\">"
					+ "<input type=\"button\" value=\"Listar Respostas\"  onclick=\"window.location='ListaQuiz'");

			// localizar o Cookie selecionado na lista de cookies
			String valor = CookieUtilities.getCookieValue(request, quiz, "0");
			// somar um no valor deste cookie
			int contador = Integer.parseInt(valor) + 1;
			// salvar o cookie na resposta http
			response.addCookie(new Cookie(quiz, String.valueOf(contador)));
					
		}
	}

	public String montaTela(String msg) {

		return "<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<meta charset=\"UTF-8\">\n"
				+ "<title>Cadastro</title>\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"../style/paginas.css\">\n"
				+ "</head>\n" + "<body>\n" + "<h2>Quiz Amigoss</h2><hr/>\n"
				+ "<h2>Respostas</h2><hr/>\n" + msg + "\n" + "</body>\n"
				+ "</html>";

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}