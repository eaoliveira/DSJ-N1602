package quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets.libs.WebUtilities;

@WebServlet("/cadastraVoto")
public class CadastraVoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

		String header = WebUtilities.loadFile(this, "/resources/header.html");
		String footer = WebUtilities.loadFile(this, "/resources/footer.html");
		
		// Obter o voto do navegador
		String voto = request.getParameter("voto");

		if (voto != null) {
			// Localiza o Coookie correspondente ao voto selecionado
			String valor = WebUtilities.getCookieValue(request, voto, "0");
			// Atualiza a contagem de votos
			int qtd = Integer.parseInt(valor) + 1;
			// Cria um cookie para devolver ao cliente
			Cookie ck = new Cookie(voto, String.valueOf(qtd));
			// Envia o cookie para o cliente
			response.addCookie(ck);
			
			header = header.replace("TITULO", "Obrigado por responder nosso quiz!");
		    out.println(header + "<div data-row>" +
		    		"<input type=\"submit\" id=\"submitL\" value=\"Lista Respostas\" formaction=\"listaVoto\">" 
		    		+ footer);
		} else {
			header = header.replace("TITULO", "Não foi selecionado nenhum ítem");
		    out.println(header + "<div data-row>" + footer);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
