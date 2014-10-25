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
			// Salva a refer�ncia do objeto na sess�o
			Calendar data = Calendar.getInstance();
			data.set(1999, 10, 20);
			Calendar data2 = Calendar.getInstance();
			data2.set(2002, 11, 15);
			ses.setAttribute("objeto", agora);
			ses.setAttribute("objeto2", data.getTime());
			ses.setAttribute("objeto3", data2.getTime());

			// Desvia a requisi��o Web para outra p�gina (Servlet/Jsp)
			RequestDispatcher rd = request.getRequestDispatcher("jsps/listaObjeto.jsp");
			rd.forward(request, response);
		} else {
			// Cria objeto para armazenar informa��es
			// que ser�o utilizadas na montagem da
			// p�gina de resposta ao usu�rio
			Mensagem msg = new Mensagem();
			msg.setTitulo("N�o encontrei par�metro v�lido!");
			msg.setTexto("N�o foi informado o par�metro necess�rio:\ndata");
			msg.setUrl("../index.html");

			// Salva o objeto na sess�o
			request.getSession().setAttribute("msg", msg);

			// Solicita ao navegador Web o redirecionamento
			// para outra p�gina no servidor de aplica��o
			response.sendRedirect("jsps/resultTagLib.jsp");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}