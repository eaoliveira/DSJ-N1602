package br.senai.sp.cadastro.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senai.sp.cadastro.model.Cliente;
import br.senai.sp.cadastro.model.GerenteDeDados;

@SuppressWarnings("serial")
@WebServlet("/ListaDados")
public class ListaDados extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GerenteDeDados dados = GerenteDeDados.getInstance();
		
		HttpSession ses = req.getSession();
		
		List<Cliente> lista = dados.getClientes();
		ses.setAttribute("clientes", lista);

		resp.sendRedirect("listaClientes.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
