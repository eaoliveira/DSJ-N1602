package alunoPrj.view;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alunoPrj.bean.Mensagem;
import alunoPrj.dao.AlunoDao;
import alunoPrj.dao.AlunoException;

@WebServlet("/cadaluno")
public class CadAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private AlunoDao dao;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Mensagem bean = new Mensagem();

		try {
			String nome = request.getParameter("nome");
			String matricula = request.getParameter("matricula");
			dao.addAluno(nome, matricula);
			
			bean.setTexto("Dados gravados com sucesso!");
			bean.setPag("cadaluno.html");
		} catch (AlunoException ex) {
			bean.setTexto(ex.getMessage());
		}
		
		request.getSession().setAttribute("msg", bean);
		response.sendRedirect("saida.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
