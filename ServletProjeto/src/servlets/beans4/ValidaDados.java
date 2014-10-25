package servlets.beans4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
      out.print(montaTela(
    		  "<h3>Dados Digitados<h3>\n" +
          "<table>\n" +
          "<tr><td>Nome:</td><td>" + nome + "</td></tr>\n" +
          "<tr><td>Idade:</td><td>" + idade + "</td></tr>\n" +
          "</table>\n" +
          "<input type=\"button\" value=\"Retornar\"\n" +
    		  		"onclick=\"window.location.replace('jsps/telaDados.html');\">"));
    }
  }

  public String montaTela(String msg) {
    return 
    		"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n" +
    		"\"http://www.w3.org/TR/html4/loose.dtd\">\n" +
    		"<html>\n" +
        "<head>\n" +
        "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n" +
        "<title>Cadastro</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<h2>Dados Cadastrais</h2>\n" + 
        msg + "\n" +
        	"</body>\n" +
        	"</html>";
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}