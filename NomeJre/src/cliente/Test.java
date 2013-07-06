package cliente;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import xml.Collection;
import xml.Nome;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class Test {
	public static void main(String[] args) throws Exception {
		// Conecta ao RESTful Web Service
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());

		// Obtém e lista um o Objeto Nome via Web Services
		System.out.println(service.path("bean/version")
				.accept(MediaType.TEXT_PLAIN).get(String.class));

		// Insere um Objeto Nome via Web Service
		Nome nome = new Nome();
		nome.setIdade(25);
		nome.setPrimeiroNome("beltrano");
		System.out.println(service.path("bean")
		 .accept(MediaType.APPLICATION_XML).post(ClientResponse.class, nome));
		
		// Obtém e lista um o Objeto Nome via Web Services
		System.out.println(service.path("bean/beltrano")
	     .accept(MediaType.APPLICATION_XML)
	     .header("Content-Type", "text/plain")
	     .get(String.class));

		Collection cli = service.path("bean/fulano")
		 .accept(MediaType.APPLICATION_XML)
 	     .header("Content-Type", "text/plain")
		 .get(Collection.class);
		System.out.println(cli.getNome() + " " + cli.getNome().size());
		for(Nome x : cli.getNome())
			System.out.println(x);
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://127.0.0.1:8080/NomeWeb/srv/")
				.build();
	}

}