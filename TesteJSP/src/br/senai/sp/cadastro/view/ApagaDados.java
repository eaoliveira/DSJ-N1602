package br.senai.sp.cadastro.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.cadastro.model.GerenteDeDados;

@SuppressWarnings("serial")
@WebServlet("/ApagaDados")
public class ApagaDados extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] ids = req.getParameterValues("id");

		GerenteDeDados dados = GerenteDeDados.getInstance();
		for (int i = 0; i < ids.length; i++) {
			dados.remover(Integer.parseInt(ids[i]));
		}
		
		resp.sendRedirect("ListaDados");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
