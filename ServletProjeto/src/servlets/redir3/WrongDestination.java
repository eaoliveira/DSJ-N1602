package servlets.redir3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servlet that sends IE users to the Netscape home page and Netscape (and all
 * other) users to the Microsoft home page.
 * <P>
 * Taken from Core Servlets and JavaServer Pages 2nd Edition from Prentice Hall
 * and Sun Microsystems Press, http://www.coreservlets.com/. &copy; 2003 Marty
 * Hall; may be freely used or adapted.
 */

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
