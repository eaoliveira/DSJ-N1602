package Sever3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Sever3.Gerente;
import Sever3.Cursos;

@WebServlet("Sever3/validarCurso")
public class ValidarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String desc = request.getParameter("desc");

		Mensagem msg = new Mensagem();

		if (nome.isEmpty() || desc.isEmpty()) {
			msg.setTexto("Existem campos não informados");
			msg.setTitulo("Erro == Cadastro Cursos");
			msg.setUrl("../index.html");
		} else {
			Cursos obj = new Cursos();
			obj.setNome(nome);
			obj.setDesc(desc);

			Gerente.getInstance().salvar(obj);

			msg.setTexto("Sucesso no cadastro do Curso");
			msg.setTitulo("== Cad Cursos ==");
			msg.setUrl("../index.html");

		}
		request.getSession().setAttribute("msg", msg);

		response.sendRedirect("resultPage.jsp");
	}
}
