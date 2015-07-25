package Sever1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HTML/cadastro")
public class ValidaDados extends javax.servlet.http.HttpServlet implements
    javax.servlet.Servlet {
  static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	
    String nome = request.getParameter("nome");
    String end = request.getParameter("end");
    String fone = request.getParameter("fone");
    String email = request.getParameter("email");
    PrintWriter out = response.getWriter();
    
    if(nome.isEmpty() || end.isEmpty() || fone.isEmpty() || email.isEmpty()) {
      out.print(montaTela(
    		  "<h3>Erro:<h3>\n" +
    		  "<p>Alguns dados n&atilde;o foram informados\n" +
          "<br><br>\n" +
          "<input type=\"button\" value=\"Voltar\"  onclick=\"window.history.back(-1);\">"));
    } else {
      out.print(montaTela("<h3>Dados Digitados<h3>\n" +
    	  "<p>Nome: " + nome + "</p>\n" +
          "<p>Idade: " + end + "</p>\n" +
          "<p>Idade: " + fone + "</p>\n" +
          "<p>Email: " + email + "</p>\n" +
          "<p>\n" +
          "<input type=\"button\" value=\"Listar Resposta \"\n" +
    		  		"onclick=\"window.location.replace('../cadastro.html');\"></p>"));
    }
  }

  public String montaTela(String msg) {
    return 
    		"<!DOCTYPE html>\n" +
    		"<html>\n" +
        "<head>\n" +
        "<meta charset=\"UTF-8\">\n" +
        "<title>Cadastro</title>\n" +
		"<link rel=\"stylesheet\" type=\"text/css\" href=\"../style/paginas.css\">\n" + 
        "</head>\n" +
        "<body>\n" +
        "<h2>Cadastro Amigos</h2><hr/>\n" + 
        msg + "\n" +
        	"</body>\n" +
        	"</html>";
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}