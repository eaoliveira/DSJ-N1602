package view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Messages {
  private Messages(){}
  
  public static void add(FacesContext ctx, String msg) {
	  ctx.addMessage("form", new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
  }
  
  public static void add(FacesContext ctx, String campo, String msg) {
	  ctx.addMessage("form:"+campo, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
  }
}
