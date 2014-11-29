package tela;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpresaDao;
import bean.Mensagem;
import modelo.Empresa;

@SuppressWarnings("serial")
@WebServlet("/incluiEmpresa")
public class ProcessaIns extends HttpServlet {
	@EJB
	private EmpresaDao dao;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// obtem os dados para salvar
		String razao = request.getParameter("razao");
		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		
		// salva os dados
		Empresa obj = new Empresa();
		obj.setRazao(razao);
		obj.setNome(nome);
		obj.setCnpj(cnpj);
		dao.adiciona(obj);
		
		// prepara a mensagem para o usuario
		Mensagem msg = new Mensagem();
		msg.setTitulo("Cadastro de Empresas");
		msg.setTexto("Sucesso na Inclusão");
		msg.setUrl("index.html");
		
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
