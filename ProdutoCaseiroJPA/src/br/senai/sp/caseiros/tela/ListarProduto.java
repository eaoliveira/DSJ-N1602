package br.senai.sp.caseiros.tela;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.caseiros.control.ProdutoDao;
import br.senai.sp.caseiros.modelo.Produto;

@WebServlet("/index.html")
public class ListarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ProdutoDao dao;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Produto> lista = dao.getLista();
		request.getSession().setAttribute("produtos", lista);
		request.getRequestDispatcher("lista.jsp").forward(request, response);
	}
}
