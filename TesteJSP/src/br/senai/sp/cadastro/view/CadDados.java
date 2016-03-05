package br.senai.sp.cadastro.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.cadastro.model.Cliente;
import br.senai.sp.cadastro.model.GerenteDeDados;

@SuppressWarnings("serial")
@WebServlet("/CadDados")
public class CadDados extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String end = req.getParameter("end");
		String email = req.getParameter("email");
		String fone = req.getParameter("fone");
		
		Cliente obj = new Cliente();
		obj.setNome(nome);
		obj.setEmail(email);
		obj.setEndereco(end);
		obj.setFone(fone);
		
		GerenteDeDados dados = GerenteDeDados.getInstance();
		dados.salvar(obj);
		
		resp.sendRedirect("ListaDados");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
