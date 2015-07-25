package Sever3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Sever3.Gerente;
import Sever3.Mensagem;

@WebServlet("/removeItens")
public class RemoveItens extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String[] listaARemover = request.getParameterValues("del");

		Mensagem msg = new Mensagem();
		
		if(listaARemover != null && listaARemover.length > 0) {
			Gerente.getInstance().remover(listaARemover);
			msg.setTitulo("Erro == Cadastro Cursos");
			msg.setTexto(listaARemover.length + " Itens removidos");
		} else {
			msg.setTitulo("Atenção === Cadastro Cursos");
			msg.setTexto("Não existem itens a serem removidos");
		}
		msg.setUrl("index.html");
		request.getSession().setAttribute("msg",msg);
		response.sendRedirect("resultPage.jsp");
	}

}
