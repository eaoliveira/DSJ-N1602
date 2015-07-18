package br.senai.sp.cadastro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastra")
public class CadastraDados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String end = request.getParameter("end");
		String fone = request.getParameter("fone");
		String mail = request.getParameter("mail");
		
		if(nome.isEmpty() || end.isEmpty() || fone.isEmpty() || mail.isEmpty() ) {
			// Erro
			response.sendRedirect("erro.html");
		} else {
			// OK
			PrintWriter out = response.getWriter();
			out.println(monstaPagina(nome, end, fone, mail));
		}
	}

   private String monstaPagina(String nome, String end, String fone, String mail) {
	   String inicio = "<!DOCTYPE html><html manifest=\"resources/cache.manifest\">" +
			   "<head><meta charset=\"UTF-8\">" +
			   "<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/site.css\">" +
			   "<title>Dados Cadastrais</title></head>" +
			   "<body><h3>Dados Cadastrais</h3>" +
			   "<form action=\"index.html\"><table class=\"Entrada\">";
	   
	   String bloco = "<tr><td>Nome:</td><td>" + nome + "</td></tr>" +
	   "<tr><td>End:</td><td>" + end + "</td></tr>" +
	   "<tr><td>Fone:</td><td>" + fone + "</td></tr>" +  
	   "<tr><td>E-Mail:</td><td>" + mail + "</td></tr>";
	   
	  String fim = "<tr><td><input type=\"submit\" value=\"Voltar\" /></td><td>&nbsp;</td></tr>" +
	   "</table></form></body></html>";
	  
	  return inicio + bloco + fim;
   }
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
