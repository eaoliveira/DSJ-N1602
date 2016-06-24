package tela;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Mensagem;
import dao.PedidoDao;
import model.Endereco;
import model.Pedido;

@WebServlet("/gravaPedido")
public class GravaPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger log = Logger.getLogger("GravaPedido");

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PedidoDao dao = PedidoDao.getInstance();		
		
		int idEndereco = Integer.parseInt(request.getParameter("endereco"));		
		Endereco end = dao.getEndereco(idEndereco);
		
		log.log(Level.WARNING, "end: " + end);
		
		if(end != null) {
			Pedido ped  = new Pedido();
			ped.setCliente(request.getParameter("cliente"));
			ped.setCodigoProduto(request.getParameter("produto"));
			ped.setEntrega(end);

			dao.adiciona(ped);

			Mensagem msg = new Mensagem();
			msg.setTitulo("Sucesso");
			msg.setTexto("Pedido gravado");
			msg.setUrl("inicio");

			request.getSession().setAttribute("count", dao.contadorEnderecos());
			request.getSession().setAttribute("msg", msg);
			response.sendRedirect("resultPage.jsp");
		} else {
			Mensagem msg = new Mensagem();
			msg.setTitulo("O Pedido não foi gravado");
			msg.setTexto("O Endereço não foi encontrado");
			msg.setUrl("inicio");

			request.getSession().setAttribute("count", dao.contadorEnderecos());
			request.getSession().setAttribute("msg", msg);
			response.sendRedirect("resultPage.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
