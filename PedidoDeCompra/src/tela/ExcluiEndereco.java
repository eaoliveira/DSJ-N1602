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

@WebServlet("/excluiEndereco")
public class ExcluiEndereco extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Logger log = Logger.getLogger("ExcluiEndereco");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Mensagem msg = new Mensagem();
		String[] ids = request.getParameterValues("endid");

		PedidoDao dao = PedidoDao.getInstance();
		
		if (ids == null) {
			msg.setTexto("Não existe item selecionado!");
		} else {
			boolean houveFalha = false;
			for (int i = 0; i < ids.length; i++) {
				int id = Integer.parseInt(ids[i]);
				if(!dao.delEndereco(id)) {
					houveFalha = true;
					log.log(Level.WARNING, "houve falha na exclusão");
					break;
				}
			}
			if(!houveFalha)
				msg.setTexto("Excluido(s) com sucesso");
			else
				msg.setTexto("O Endereço não existe!");
		}
		
		int count = dao.contadorEnderecos();
		
		if(count > 0) {
			msg.setUrl("listarEnderecos");
		} else {
			msg.setUrl("inicio");
		}
		
		request.getSession().setAttribute("count" ,count);
		request.getSession().setAttribute("msg" ,msg);
		response.sendRedirect("resultPage.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
