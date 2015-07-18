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

		String ate18 = Utilitarios.getCookieValue(request, "ate18", "0");
		String ate26 = Utilitarios.getCookieValue(request, "ate26", "0");
		String ate35 = Utilitarios.getCookieValue(request, "ate35", "0");
		String ate99 = Utilitarios.getCookieValue(request, "ate99", "0");

		if (ate18.equals("0") && ate26.equals("0") && ate35.equals("0")
				&& ate99.equals("0")) {

			String msg = "Não existem resposta para este Quiz!";
			ses.setAttribute("msg", msg);
			
			response.sendRedirect("salvaQuiz.jsp");

		} else {
			ses.setAttribute("ate18", ate18);
			ses.setAttribute("ate26", ate26);
			ses.setAttribute("ate35", ate35);
			ses.setAttribute("ate99", ate99);

			response.sendRedirect("listaQuiz.jsp");
		}
	}
}
