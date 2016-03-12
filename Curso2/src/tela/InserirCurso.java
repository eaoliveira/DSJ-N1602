package tela;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CursoDao;
import bean.Mensagem;
import modelo.Curso;

@SuppressWarnings("serial")
@WebServlet("/incluirCurso")
public class InserirCurso extends HttpServlet {

	@EJB
	private CursoDao dados;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// obtem os dados para salvar
		String nome = request.getParameter("nome");
		String desc = request.getParameter("desc");
		// salva os dados
		Curso obj = new Curso();
		obj.setNome(nome);
		obj.setDescr(desc);
		dados.adiciona(obj);
		// prepara a mensagem para o usuario
		Mensagem msg = new Mensagem();
		msg.setTitulo("Cadastro de Cursos");
		msg.setTexto("Sucesso na Inclusão");
		msg.setUrl("index.html");
		
		// salva a mensagem
		request.getSession().setAttribute("msg", msg);
		// envia a mensagem
		response.sendRedirect("resultPage.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
