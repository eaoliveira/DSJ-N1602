package quiz;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


public class Utilitarios {
	public static String getCookieValue(HttpServletRequest request,
			String cookieName, String valorPadrao) {
	      Cookie[] cookies = request.getCookies();
	      
	      String resposta = valorPadrao;
	      
	      if(cookies != null) {
	        for(int i = 0;i < cookies.length;i++) {
	          Cookie cookie = cookies[i];
	          String nome = cookie.getName();
	          
	          if(nome.equals(cookieName)) {
	          	resposta = cookie.getValue();
	          	break;
	          }
	        }
	      }
	      return resposta;
	}
}
