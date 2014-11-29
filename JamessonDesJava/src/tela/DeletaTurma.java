package tela;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TurmaDao;
import bean.Mensagem;


@WebServlet("/DeletaTurma")
public class DeletaTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private TurmaDao dao;
    public DeletaTurma() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// obtendo a lista dos ids para deletar o JSP que envia essa informação
				String[] ids = request.getParameterValues("del");
				// Preparar a mensagem de saida para o usuario
				Mensagem msg = new Mensagem();
				msg.setTitulo("Cadastro de Turma");
		       
				// Tem algum registro selecionado
				if (ids != null) {
					for (String id : ids)
						dao.remove(Integer.parseInt(id));  // apaga o registro
					
					msg.setTexto("Sucesso na DeleÃ§Ã£o");
					msg.setUrl("index.html");
				} else { // Reclama que nada foi selecionado
					msg.setTexto("NÃ£o foi selecionado nenhum registro");
				}
		        // salva a mensagem
				request.getSession().setAttribute("msg", msg);
		        // envia a mensagem
				response.sendRedirect("resultPage.jsp");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
