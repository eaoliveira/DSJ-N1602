package quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets.libs.WebUtilities;

@WebServlet("/listaVoto")
public class ListaVoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

		String header = WebUtilities.loadFile(this, "/resources/header.html");
		String footer = WebUtilities.loadFile(this, "/resources/footer.html");
		
		// Cada um dos o Coookie votados
		String ate18 = WebUtilities.getCookieValue(request, "ate18", "0");
		String ate26 = WebUtilities.getCookieValue(request, "ate26", "0");
		String ate35 = WebUtilities.getCookieValue(request, "ate35", "0");
		String acima35 = WebUtilities.getCookieValue(request, "acima35", "0");

		if (ate18.equals("0") && ate26.equals("0") && ate35.equals("0")
				&& acima35.equals("0")) {
			header = header.replace("TITULO", "Não foi selecionado nenhum ítem");
		    out.println(header + "<div data-row>" + footer);
		} else {
			header = header.replace("TITULO", "");
			out.println(header +
				"<div id=\"center\">" +
					"<div id=\"toLeft\">" +
						"<p><b>Qtd.</b></p>" +
						"<p><em>" + ate18 + "</em></p>" +
						"<p><em>" + ate26 + "</em></p>" +
						"<p><em>" + ate35 + "</em></p>" +
						"<p><em>" + acima35 + "</em></p>" +
					"</div>" +
					"<div id=\"toRight\">" +
						"<p><b>Resposta</b></p>" +
						"<p><span>até 18</span></p>" +
						"<p><span>de 19 até 26</span></p>" +
						"<p><span>de 27 até 35</span></p>" +
						"<p><span>acima de 35</span></p>" +
					"</div>" +
				"</div>" +
			"<div data-row>"
			+ footer);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
