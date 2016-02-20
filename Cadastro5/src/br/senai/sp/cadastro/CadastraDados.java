package br.senai.sp.cadastro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastra")
public class CadastraDados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String end = request.getParameter("end");
		String fone = request.getParameter("fone");
		String mail = request.getParameter("mail");

		if (nome.isEmpty() || end.isEmpty() || fone.isEmpty() || mail.isEmpty()) {
			// Erro
			response.sendRedirect("erro.html");
		} else {
			// OK

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(monstaPagina(nome, end, fone, mail));
		}
	}

	private String monstaPagina(String nome, String end, String fone, String mail) throws IOException {
		String header = loadFile(this, "/resources/header.html").replace("TITULO", "Cadastro");
		String footer = loadFile(this, "/resources/footer.html");

		String bloco = "<fieldset>" + 
				"<h2>Cadastro Efetuado</h2>" +
				"<p><b>Nome</b>: " + nome + "</p>" +
				"<p><b>End</b>: " + end + "</p>" +
				"<p><b>Fone</b>: " + fone + "</p>" +
				"<p><b>E-Mail</b>: " + mail + "</p>" +
			"</fieldset>";

		return header + bloco + footer;
	}

	private String loadFile(HttpServlet ref, String url) throws IOException {
		BufferedReader fin = new BufferedReader(
				new InputStreamReader(ref.getServletContext().getResourceAsStream(url)));
		StringBuilder buff = new StringBuilder();
		for (String linha = fin.readLine(); linha != null; linha = fin.readLine()) {
			buff.append(linha);
		}
		return buff.toString();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
