package servlets.redir3;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/jsps/WrongDestination")
@SuppressWarnings("serial")
public class WrongDestination extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String userAgent = request.getHeader("User-Agent");
    
    if((userAgent != null) &&  (userAgent.indexOf("Firefox") != -1)) {
      response.sendRedirect("http://www.microsoft.com");
    } else {
      response.setContentType("text/html");
      response.sendRedirect("http://www.mozilla.org");
    }
  }
}
