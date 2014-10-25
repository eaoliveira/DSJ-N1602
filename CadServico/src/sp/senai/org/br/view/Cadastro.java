package sp.senai.org.br.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sp.senai.org.br.model.Servico;

@WebServlet
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Obtem os parâmetros da requisição WEB
		String nome = request.getParameter("nome");
		String codigo = request.getParameter("codigo");
		
		// Salva os dados em um Objeto
		Servico serv = new Servico();
		serv.setNome(nome);
		serv.setCodigo(codigo);
		
		// Registra o objeto na Sessão WEB
		request.getSession().setAttribute("srv", serv);
		
		// Redireciona a requisição para um JSP
		response.sendRedirect("lista.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
