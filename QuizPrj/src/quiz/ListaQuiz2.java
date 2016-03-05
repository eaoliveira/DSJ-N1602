package quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets.libs.WebUtilities;

@WebServlet("/ListaQuiz2")
public class ListaQuiz2 extends HttpServlet {
	static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String ate18 = Utilitarios.getCookieValue(request, "ate18", "0");
		String ate26 = Utilitarios.getCookieValue(request, "ate26", "0");
		String ate35 = Utilitarios.getCookieValue(request, "ate35", "0");
		String ate99 = Utilitarios.getCookieValue(request, "ate99", "0");

		if (ate18.equals("0") && ate26.equals("0") && ate35.equals("0")
				&& ate99.equals("0")) {

			String msg = "Não existem resposta para este Quiz!";
			
			Utilitarios.salvaQuiz(this, response.getWriter(), msg);
		} else {
			String header = WebUtilities.loadFile(this, "/resources/header.html");
			String footer = WebUtilities.loadFile(this, "/resources/footer.html");
			String body = 	
				"<form id='form1' action='index.html'>" +
					"<div id='center'>" +
						"<div id='toLeft'>" +
							"<p><b>Qtd.</b></p>" +
							"<p><em>" + ate18 + "</em></p>" +
							"<p><em>" + ate26 + "</em></p>" +
							"<p><em>" + ate35 + "</em></p>" +
							"<p><em>" + ate99 + "</em></p>" +
						"</div>" +
						"<div id='toRight'>" +
							"<p><b>Resposta</b></p>" +
							"<p><span>até 18</span></p>" +
							"<p><span>de 19 até 26</span></p>" +
							"<p><span>de 27 até 35</span></p>" +
							"<p><span>acima de 35</span></p>" +
						"</div>" +
					"</div>" +
					"<div data-row>" +
						"<input type='submit' id='submit' value='Voltar'>" +
					"</div>" +
				"</form>";
			
			PrintWriter out = response.getWriter();
			out.println(header + body +	footer);
		}
	}
}
