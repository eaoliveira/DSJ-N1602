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

@SuppressWarnings("serial")
@WebServlet("/ExcluiAluno")
public class ExcluiAluno extends HttpServlet {
	@EJB
	private AlunoDao dao;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Mensagem msg = new Mensagem();
		String[] ids = request.getParameterValues("alunoid");

		if (ids == null) {
			msg.setTexto("Não existe item selecionado!");
		} else {
			for (int i = 0; i < ids.length; i++) {
				int id = Integer.parseInt(ids[i]);
				dao.delAluno(id);
			}
			msg.setTexto("Excluido(s) com sucesso");
		}
		
		msg.setPag("ListaAluno");
		request.getSession().setAttribute("msg" ,msg);
		response.sendRedirect("saida.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
