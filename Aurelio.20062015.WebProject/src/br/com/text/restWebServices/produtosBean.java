package br.com.text.restWebServices;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import br.com.text.Xml.produtos;
import br.com.text.service.Servico;

@Path("bean")
public class produtosBean {
	private Servico dao = Servico.getInstance();


	@GET
	@Path("{produtos}")
	@Produces(MediaType.APPLICATION_XML)
	public List<produtos> getByNome(@PathParam("produto") String produtos) {
		return dao.listarProdutos();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Nome addNome(JAXBElement<Nome> obj) {
		Nome n = obj.getValue();
		return dao.salvar(n);
	}

	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateNome(JAXBElement<Nome> obj) {
		Nome n = obj.getValue();
		if(dao.salvar(n) != null)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_XML)
	public List<Nome> getAll() {
		return dao.listaTodos();
	}

	@GET
	@Path("key/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Nome getById(@PathParam("id") int num) {
		return dao.buscar(num);
	}

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response delNome(@PathParam("id") int num) {
		dao.remover(num);
		return Response.ok().build();
	}

	@GET
	@Path("count")
	@Produces(MediaType.APPLICATION_XML)
	public String getCount() {
		return String.valueOf(dao.quantos());
	}
}
