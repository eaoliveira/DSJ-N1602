package tela;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Mensagem;
import dao.CursoDao;
import modelo.Curso;

@SuppressWarnings("serial")
@WebServlet("/incluiCurso")
public class IncluiCurso extends HttpServlet {
	@EJB
	private CursoDao dao;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// obtem os dados para salvar
		String nome = request.getParameter("nome");
		String desc = request.getParameter("desc");
		Date inicio = dao.makeDate(request.getParameter("inicio"));
		int horas = Integer.parseInt(request.getParameter("horas"));
		// salva os dados
		Curso obj = new Curso();
		obj.setNome(nome);
		obj.setDescr(desc);
		obj.setInicio(inicio);
		obj.setHoras(horas);
		dao.adiciona(obj);
		// prepara a mensagem para o usuario
		Mensagem msg = new Mensagem();
		msg.setTitulo("Cadastro de Cursos");
		msg.setTexto("Sucesso na Inclusão");
		msg.setUrl("cadCurso.html");
		
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
