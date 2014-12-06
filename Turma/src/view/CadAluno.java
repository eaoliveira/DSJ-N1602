package view;

import java.io.IOException;

import javax.ejb.EJB;
import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;
import model.EntityDao;
import model.Turma;

@WebServlet("/CadAluno")
public class CadAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private EntityDao dao;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		ses.setAttribute("titulo", "Cad Aluno");
		ses.setAttribute("url", "cadaluno.html");
		
		try {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			int idturma = Integer.parseInt(request.getParameter("turma"));

			Turma curso = dao.getTurma(idturma);

			if (nome.isEmpty() || email.isEmpty()) {
				ses.setAttribute("msg", "O(s) Nome e E-Mail não podem estar vazios");
			} else if (curso == null) {
				ses.setAttribute("msg", "Problema: A Turma não está cadastrada");
			} else {

				Aluno obj = new Aluno();
				obj.setNome(nome);
				obj.setEmail(email);
				obj.setTurma(curso);

				curso.getAlunos().add(obj);

				dao.salva(curso);
				//dao.salva(obj);

				ses.setAttribute("msg", "Aluno cadastrado com sucesso");
			}
		} catch (PersistenceException ex) {
			ses.setAttribute("msg", "Problema na Conexão com o Banco de Dados");
		}

		response.sendRedirect("resultado.jsp");
	}

}
