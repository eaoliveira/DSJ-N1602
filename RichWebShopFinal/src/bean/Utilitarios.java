package bean;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public abstract class Utilitarios {
	public static String getSessionId() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) ctx.getExternalContext()
				.getSession(false);
		String sessionId = session.getId(); // id da sessao
		return sessionId;
	}

	public static void sendMessage(String praQuem, String msg) {
		sendMessage(praQuem, msg, FacesMessage.SEVERITY_INFO);
	}
	
	public static void sendError(String praQuem, String msg) {
		sendMessage(praQuem, msg, FacesMessage.SEVERITY_ERROR);
	}
	
	private static void sendMessage(String praQuem, String msg, Severity info) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(praQuem, new FacesMessage(info, msg, msg));

	}
	
}
