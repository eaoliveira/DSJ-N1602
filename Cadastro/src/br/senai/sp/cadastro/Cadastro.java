package br.senai.sp.cadastro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String end = request.getParameter("end");
		String fone = request.getParameter("fone");
		String email = request.getParameter("email");
		
		String erro = "";
		
		if(nome.isEmpty())
			erro += "<li>Nome</li>";
		if(end.isEmpty())
			erro += "<li>Endereço</li>";
		if(fone.isEmpty())
			erro += "<li>Telefone</li>";
		if(email.isEmpty())
			erro += "<li>E-Mail</li>";
		
		String html = "";
		
		if(erro.isEmpty()) {
			html = 
					"<h3>Cliente Cadastrado</h3><hr>\n" +
					"<p>Nome: " + nome + "\n" +
					"<p>End.: " + end + "\n" +
					"<p>Fone: " + fone + "\n" +
					"<p>E-Mail: " + email + "\n";
		} else {
			html = "<h3>Falta(m) Informa&ccedil;&otilde;es</h3><ul>" + erro + "</ul>";
		}
		
		String cabecalho = 
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">" +
				"<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">" +
				"<title>Insert title here</title>\n</head>\n<body>";
		String rodape =
				"<br><hr>\n<input type=\"button\" value=\"Voltar\" onclick=\""+
				"window.location.replace('index.html')\">\n</body>\n</html>";
		
		
		PrintWriter out = response.getWriter();
		out.println(cabecalho + html + rodape);
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
