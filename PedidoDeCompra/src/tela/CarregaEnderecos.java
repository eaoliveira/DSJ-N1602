package tela;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PedidoDao;

@WebServlet("/carregaEnderecos")
public class CarregaEnderecos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PedidoDao dao = PedidoDao.getInstance();
		
		if(dao.contadorEnderecos() > 0) {
			request.getSession().setAttribute("enderecos", dao.getEnderecos());
			response.sendRedirect("efetuaPedido.jsp");
		} else {
			response.sendRedirect("inicio");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
