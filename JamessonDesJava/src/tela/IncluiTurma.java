package tela;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Mensagem;
import dao.TurmaDao;
import modelo.Turma;


@WebServlet("/IncluiTurma")
public class IncluiTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	TurmaDao dao;
	
    public IncluiTurma() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
		Date inicio = null;
		
		// O Servlet vai enviar os campos via request.
		String descricao = request.getParameter("descricao");
		String numHoras = request.getParameter("numHoras");
		String titulo = request.getParameter("titulo");
		try {
			inicio = new java.sql.Date(format.parse(request.getParameter("inicio")).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		// salva os dados - utilizando a camada modelo
		Turma obj = new Turma();
		obj.setDescricao(descricao);
		obj.setInicio(inicio);
		obj.setNumHoras(Integer.parseInt(numHoras));
		obj.setTitulo(titulo);
		dao.adiciona(obj);
		
		// prepara a mensagem para o usuario
		Mensagem msg = new Mensagem();
		msg.setTitulo("Cadastro de Turma");
		msg.setTexto("Sucesso na Inclusão");
		msg.setUrl("index.html");
		
		// salva a mensagem
		request.getSession().setAttribute("msg", msg);
		
		// envia a mensagem
		response.sendRedirect("resultPage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
