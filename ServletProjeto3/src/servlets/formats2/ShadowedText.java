package servlets.formats2;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/jsps/ShadowedText")
@SuppressWarnings("serial")
public class ShadowedText extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String wantsList = request.getParameter("showList");
		
		if (wantsList != null) {
			showFontList(response);
		} else {
			String message = request.getParameter("message");
			
			if ((message == null) || (message.length() == 0)) {
				message = "Falta o parâmetro mensagem";
			}
			
			String fontName = request.getParameter("fontName");
			
			if ((fontName == null) || (fontName.length() == 0)) {
				fontName = "Serif";
			}
			
			String fontSizeString = request.getParameter("fontSize");
			
			int fontSize;
			
			try {
				fontSize = Integer.parseInt(fontSizeString);
			} catch (NumberFormatException nfe) {
				fontSize = 90;
			}
			
			response.setContentType("image/jpeg");
			
			MessageImage.writeJPEG(
					MessageImage.makeMessageImage(message, fontName, fontSize),
					response.getOutputStream());
		}
	}

	private void showFontList(HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		
		String docType = "<!DOCTYPE html>\n";
		String title = "Fonts Dispon&iacute;veis no Servidor";
		
		out.println(docType + 
				"<html>\n" +
				"<head>\n<title>" + title	+ "</title>\n" +
				"<meta charset=\"UTF-8\">\n" +
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"../style/paginas.css\">\n" + 
				"</head>\n" + 
				"<body>\n" +
			    "<h2>" + title + "</h2>\n<hr/>\n" + 
				"<ul>\n");
		
		String[] fontNames = MessageImage.getFontNames();
		for (int i = 0; i < fontNames.length; i++) {
			out.println("  <li>" + fontNames[i]);
		}
		out.println(
				"</ul>\n" + 
				"<input type=\"button\" value=\"Voltar\" onclick=\"window.location='ShadowedText.html'\">\n" +
				"</body>\n</html>");
	}
}
