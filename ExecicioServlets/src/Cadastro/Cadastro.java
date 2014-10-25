package Cadastro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
   		
   		
   		String nome = request.getParameter("nome");
   		String end = request.getParameter("Endereço");
   		String fone = request.getParameter("telefone");
   		String email = request.getParameter("E-mail");
   		
   		
   		
   	Cadas cad = new Cadas();
   	
   	cad.setNome(nome);
   	cad.setEnd(end);
   	cad.setFone(fone);
   	cad.setEmail(email);	
   	
   	request.getSession().setAttribute("cadas", cad);
 			  		
   	
   	response.sendRedirect("lista.jsp");
		
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
