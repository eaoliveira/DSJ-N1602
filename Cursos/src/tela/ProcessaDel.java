package tela;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CursoDao;
import bean.Mensagem;

@SuppressWarnings("serial")
@WebServlet("/deletaCurso")
public class ProcessaDel extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// obtendo a lista dos ids para deletar
		String[] ids = request.getParameterValues("del");
		CursoDao cd = CursoDao.getInstance();
		// Preparar a mensagem de saida para o usuario
		Mensagem msg = new Mensagem();
		msg.setTitulo("Cadastro de Cursos");

		// Tem algum registro selecionado
		if (ids != null) {
			for (String id : ids)
				cd.remove(Integer.parseInt(id));  // apaga o registro
			
			msg.setTexto("Sucesso na Deleção");
			msg.setUrl("index.html");
		} else { // Reclama que nada foi selecionado
			msg.setTexto("Não foi selecionado nenhum registro");
		}

		// salva a mensagem
		request.getSession().setAttribute("msg", msg);
        // envia a mensagem
		response.sendRedirect("resultPage.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
