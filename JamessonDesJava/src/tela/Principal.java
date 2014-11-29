package tela;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.TurmaBean;
import dao.TurmaDao;




@WebServlet("/index.html") //Alterei para index.html. O sistema vai iniciar aqui
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private TurmaDao dao; // O dao é um EJB
   
    public Principal() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			// obter a lista de cursos
			TurmaBean obj = dao.getTurmas();
		
			// salvar os cursos na sessao http
			request.getSession().setAttribute("emp", obj); // a variavel que vou usar no JSP vai ser emp, empr recebe tudo que tem no meu obj
			// redirecionar para o jsp que monta a lista
			response.sendRedirect("lista.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
