package cliente;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import br.com.text.xml.Collection;
import br.com.text.xml.Nome;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class NomeWsDao {
	private WebResource service = null;

	public NomeWsDao() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		service = client.resource(UriBuilder.fromUri(
				"http://10.84.144.250:8080/NovoNomeXml/srv/").build());
	}

	public List<Nome> listaTodos() throws Error {
		ClientResponse cli = service.path("bean/all")
				.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);

		int retCode = cli.getStatus();
		if (retCode > 299) {
			throw new Error("Problemas no acesso aos Dados");
		}

		return cli.getEntity(Collection.class).getNome();
	}

	public List<Nome> buscar(String nome) throws Error {
		ClientResponse cli = service.path("bean/" + nome)
				.accept(MediaType.APPLICATION_XML)
				.header("Content-Type", "text/plain").get(ClientResponse.class);

		int retCode = cli.getStatus();
		if (retCode > 299) 
			throw new Error("Problemas no acesso aos Dados");

		return cli.getEntity(Collection.class).getNome();
	}

	public Nome buscar(int chave) throws Error {
		ClientResponse cli = service.path("bean/key/" + chave)
				.accept(MediaType.APPLICATION_XML)
				.header("Content-Type", "text/plain").get(ClientResponse.class);

		int retCode = cli.getStatus();
		if (retCode > 299) 
			throw new Error("Problemas no acesso aos Dados");

		return cli.getEntity(Nome.class);
	}

	public Nome salvar(Nome obj) throws Error {
		ClientResponse cli = service.path("bean")
				.accept(MediaType.APPLICATION_XML)
				.post(ClientResponse.class, obj);

		int retCode = cli.getStatus();
		if (retCode > 299) {
			throw new Error("Problemas no acesso aos Dados");
		}

		return cli.getEntity(Nome.class);
	}

	public boolean atualizar(Nome obj) throws Error {
		ClientResponse cli = service.path("bean/update")
				.accept(MediaType.APPLICATION_XML)
				.post(ClientResponse.class, obj);

		int retCode = cli.getStatus();
		if (retCode > 299) 
			return false;
		else
			return true;
	}

	public void remover(int chave) throws Error {
		ClientResponse cli = service.path("bean/" + chave)
				.accept(MediaType.APPLICATION_XML)
				.header("Content-Type", "text/plain")
				.delete(ClientResponse.class);

		int retCode = cli.getStatus();
		if (retCode > 299) 
			throw new Error("Problemas no acesso aos Dados");
	}

	public int quantos() throws Error {
		ClientResponse cli = service.path("bean/count")
				.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);

		int retCode = cli.getStatus();
		if (retCode > 299) 
			throw new Error("Problemas no acesso aos Dados");
		
		return Integer.parseInt(cli.getEntity(String.class).split("<count>")[1].split("</count>")[0]);
	}
}
