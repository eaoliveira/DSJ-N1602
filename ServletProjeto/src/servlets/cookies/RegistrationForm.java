package servlets.cookies;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/** Servlet that displays an HTML form to collect user's
 *  first name, last name, and email address. Uses cookies
 *  to determine the initial values of each of those
 *  form fields.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall; may be freely used or adapted.
 */

@SuppressWarnings("serial")
public class RegistrationForm extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
  	
    response.setContentType("text/html");
    
    PrintWriter out = response.getWriter();
    
    String actionURL = "RegistrationServlet";
    
    String firstName = CookieUtilities.getCookieValue(request, "firstName", "");
    String lastName = CookieUtilities.getCookieValue(request, "lastName", "");
    String emailAddress = CookieUtilities.getCookieValue(request, "emailAddress","");
    
    
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    String title = "Faça seu Registro";
    out.println
      (docType +
       "<HTML>\n" +
       "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
       "<BODY BGCOLOR=\"#FDF5E6\">\n" +
       "<CENTER>\n" +
       "<H1>" + title + "</H1>\n" +
       "<FORM ACTION=\"" + actionURL + "\">\n" +
       "Nome: <INPUT TYPE=\"TEXT\" NAME=\"firstName\" VALUE=\"" + firstName + "\"><BR>\n" +
       "Sobrenome:  <INPUT TYPE=\"TEXT\" NAME=\"lastName\" VALUE=\"" + lastName + "\"><BR>\n" +
       "E-mail:  <INPUT TYPE=\"TEXT\" NAME=\"emailAddress\" VALUE=\"" + emailAddress + "\"><P>\n" +
       "<INPUT TYPE=\"SUBMIT\" VALUE=\"Register\"> <input type=\"button\" value=\"Voltar\"" +
       				" onclick=\"window.history.back(-1);\" >" +
       "</FORM></CENTER></BODY></HTML>");
  }
}
