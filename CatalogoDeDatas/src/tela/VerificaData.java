package tela;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Mensagem;

@WebServlet("/verificaData")
public class VerificaData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			String temp = request.getParameter("nascimento");
			Date nascimento = sdf.parse(temp);

			temp = request.getParameter("formatura");
			Date formatura = sdf.parse(temp);

			// salvar os cursos na sessao http
			request.getSession().setAttribute("nascimento", nascimento);
			request.getSession().setAttribute("formatura", formatura);
			// redirecionar para o jsp que monta a lista
			response.sendRedirect("lista.jsp");
		} catch (ParseException ex) {
			Mensagem msg = new Mensagem();
			msg.setTitulo("Catalogo de Datas");

			msg.setTexto("Data(s) inválida(s)");

			// salva a mensagem
			request.getSession().setAttribute("msg", msg);
			// envia a mensagem
			response.sendRedirect("resultPage.jsp");

		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
