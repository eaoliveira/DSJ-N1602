package servlets.beans4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import servlets.beans4.Mensagem;

@SuppressWarnings("serial")
public class RedirecionaObj extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		Date agora = new Date();
		Object param = request.getParameter("data");

		if (param != null) {
			// Salva a referência do objeto na sessão
			Calendar data = Calendar.getInstance();
			data.set(1999, 10, 20);
			Calendar data2 = Calendar.getInstance();
			data2.set(2002, 11, 15);
			ses.setAttribute("objeto", agora);
			ses.setAttribute("objeto2", data.getTime());
			ses.setAttribute("objeto3", data2.getTime());

			// Desvia a requisição Web para outra página (Servlet/Jsp)
			RequestDispatcher rd = request.getRequestDispatcher("jsps/listaObjeto.jsp");
			rd.forward(request, response);
		} else {
			// Cria objeto para armazenar informações
			// que serão utilizadas na montagem da
			// página de resposta ao usuário
			Mensagem msg = new Mensagem();
			msg.setTitulo("Não encontrei parâmetro válido!");
			msg.setTexto("Não foi informado o parâmetro necessário:\ndata");
			msg.setUrl("../index.html");

			// Salva o objeto na sessão
			request.getSession().setAttribute("msg", msg);

			// Solicita ao navegador Web o redirecionamento
			// para outra página no servidor de aplicação
			response.sendRedirect("jsps/resultTagLib.jsp");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}