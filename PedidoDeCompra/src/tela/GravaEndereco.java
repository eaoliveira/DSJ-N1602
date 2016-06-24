package tela;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Mensagem;
import dao.PedidoDao;
import model.Endereco;

@WebServlet("/gravaEndereco")
public class GravaEndereco extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PedidoDao dao = PedidoDao.getInstance();
		
		Endereco end  = new Endereco();
		end.setLogradouro(request.getParameter("logr"));
		end.setNumero(request.getParameter("num"));
		end.setBairro(request.getParameter("bairro"));
		
		dao.adiciona(end);
		
		Mensagem msg = new Mensagem();
		msg.setTitulo("Sucesso");
		msg.setTexto("Endereço gravado");
		msg.setUrl("inicio");
		
		request.getSession().setAttribute("count", dao.contadorEnderecos());
		request.getSession().setAttribute("msg", msg);
		response.sendRedirect("resultPage.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
