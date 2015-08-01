package br.senai.sp.caseiros.tela;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.caseiros.control.ProdutoDao;
import br.senai.sp.caseiros.modelo.Mensagem;

@WebServlet("/removeItens")
public class RemoveItens extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ProdutoDao dao;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String[] listaARemover = request.getParameterValues("del");

		Mensagem msg = new Mensagem();
		
		if(listaARemover != null && listaARemover.length > 0) {
			dao.remover(listaARemover);
			msg.setTitulo("Cad Produtos");
			msg.setTexto(listaARemover.length + " Itens removidos");
		} else {
			msg.setTitulo("Atenção === Cad Produtos");
			msg.setTexto("Não existem itens a serem removidos");
		}
		msg.setUrl("index.html");
		request.getSession().setAttribute("msg",msg);
		response.sendRedirect("resultPage.jsp");
	}

}
