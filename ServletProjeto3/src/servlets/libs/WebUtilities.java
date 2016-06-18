package servlets.libs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServlet;

public class WebUtilities {
	public static String loadFile(HttpServlet ref, String url) throws IOException {
		BufferedReader fin = new BufferedReader(
				new InputStreamReader(ref.getServletContext().getResourceAsStream(url)));
		StringBuilder buff = new StringBuilder();
		for (String linha = fin.readLine(); linha != null; linha = fin.readLine()) {
			buff.append(linha);
		}
		return buff.toString();
	}

}
