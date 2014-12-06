package view;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EntityDao;
import model.Turma;

@WebServlet("/CadTurma")
public class CadTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private EntityDao dao;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		HttpSession ses = request.getSession();
		ses.setAttribute("titulo", "Cad Turma");
		ses.setAttribute("url", "cadturma.html");
		
		try {
			Turma t = new Turma();
			t.setTitulo(request.getParameter("titulo"));
			t.setDescricao(request.getParameter("desc"));
			
			if (t.getTitulo().isEmpty() || t.getDescricao().isEmpty()) {
				ses.setAttribute("msg", "O Título e descrição não podem estar vazios");
			} else {
				t.setInicio(df.parse(request.getParameter("inicio")));
				t.setNumhoras(Integer.parseInt(request.getParameter("horas")));
				
				dao.salva(t);
				ses.setAttribute("msg", "Turma cadastrada com sucesso");
			}
		} catch (ParseException ex) {
			ses.setAttribute("msg", "A Data de início está inválida");
		} catch (NumberFormatException ex) {
			ses.setAttribute("msg", "O nº de horas é inválido");
		}

		response.sendRedirect("resultado.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
