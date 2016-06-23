package quiz;

import java.io.IOException;

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
				
		String cookieName = request.getParameter("idade");
		String msg;
		
		if (cookieName == null) {
			msg = "Não foi selecionado nenhum ítem!";
		} else {
			String valor = Utilitarios.getCookieValue(request, cookieName, "0");
			int num = Integer.parseInt(valor) + 1;
			Cookie quiz = new Cookie(cookieName, String.valueOf(num));

			response.addCookie(quiz);
			
			msg = "Obrigado por responder nosso Quiz!";
		}

		request.getSession().setAttribute("msg", msg);
		response.sendRedirect("salvaQuiz.jsp");
	}
}
