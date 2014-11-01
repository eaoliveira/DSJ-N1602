package quiz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ListaQuiz")
public class ListaQuiz extends HttpServlet {
	static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession ses = request.getSession();
		
		ses.setAttribute("ate18", Utilitarios.getCookieValue(request, "ate18", "0"));
		ses.setAttribute("ate26", Utilitarios.getCookieValue(request, "ate26", "0"));
		ses.setAttribute("ate35", Utilitarios.getCookieValue(request, "ate35", "0"));
		ses.setAttribute("ate99", Utilitarios.getCookieValue(request, "ate99", "0"));
		
		response.sendRedirect("listaQuiz.jsp");
	}
}
