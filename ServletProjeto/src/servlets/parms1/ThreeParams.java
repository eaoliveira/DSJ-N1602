package servlets.parms1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Simple servlet that reads three parameters from the form data.
 * <P>
 * Taken from Core Servlets and JavaServer Pages 2nd Edition from Prentice Hall
 * and Sun Microsystems Press, http://www.coreservlets.com/. &copy; 2003 Marty
 * Hall; may be freely used or adapted.
 */

@SuppressWarnings("serial")
public class ThreeParams extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String title = "Lendo Tr&ecirc;s Par&acirc;metros";
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
		
		out.println(docType + 
				"<HTML>\n" +
				"<HEAD><TITLE>" + title	+ "</TITLE></HEAD>\n" + 
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
			    "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" + 
				"<UL>\n" +
				"  <LI><B>param1</B>: " + request.getParameter("param1") + "\n" + 
				"  <LI><B>param2</B>: " + request.getParameter("param2") + "\n" +
				"  <LI><B>param3</B>: " + request.getParameter("param3") + "\n" + 
				"</UL>\n" + 
				"</BODY></HTML>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
