package Viewer;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Aluno;
import dao.GerenteDeDados;
import dao.TurmasDao;


	@WebServlet("/CadAluno")
	public class Cadastro extends HttpServlet {
		private static final long serialVersionUID = 1L;

		@EJB
		private GerenteDeDados dao; 
		
		@EJB
		private TurmasDao daoTurma; 
		
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			
			String nome = request.getParameter("nome");
			String Email = request.getParameter("email");
			String  NumdeMatricula =  request.getParameter("numdeMatricula");

			
			// Salva os dados em um Objeto
			Aluno serv = new Aluno();
			serv.setNome(nome);
			serv.setEmail(Email);
			serv.setNumdeMatricula(NumdeMatricula);
			serv.setTurmaaCursar(daoTurma.geTurma(1));
			
			dao.salvar(serv);
			
			// Registra o objeto na Sessão WEB
			request.getSession().setAttribute("srv", serv);
			
			// Redireciona a requisição para um JSP
			response.sendRedirect("lista.jsp");
		}

		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

	}


