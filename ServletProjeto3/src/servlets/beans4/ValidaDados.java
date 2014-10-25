package servlets.beans4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsps/ValidaDados")
public class ValidaDados extends javax.servlet.http.HttpServlet implements
    javax.servlet.Servlet {
  static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	
    String nome = request.getParameter("nome");
    String idade = request.getParameter("idade");
    
    PrintWriter out = response.getWriter();
    
    if(nome.isEmpty() || idade.isEmpty()) {
      out.print(montaTela(
    		  "<h3>Erro:<h3>\n" +
    		  "<p>Alguns dados n&atilde;o foram informados\n" +
          "<br><br>\n" +
          "<input type=\"button\" value=\"Voltar\"  onclick=\"window.history.back(-1);\">"));
    } else {
      out.print(montaTela("<h3>Dados Digitados<h3>\n" +
    	  "<p>Nome: " + nome + "</p>\n" +
          "<p>Idade: " + idade + "</p>\n" +
          "<p>\n" +
          "<input type=\"button\" value=\"Voltar\"\n" +
    		  		"onclick=\"window.location.replace('telaDados.html');\"></p>"));
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
        "<h2>Dados Cadastrais</h2><hr/>\n" + 
        msg + "\n" +
        	"</body>\n" +
        	"</html>";
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}