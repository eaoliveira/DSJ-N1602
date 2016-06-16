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

import br.com.text.bancodedados.NomeService;
import br.com.text.xml.Nome;

@Path("bean")
public class NomeBean {
	private NomeService dao = NomeService.getInstance();

	@GET
	@Path("version")
	@Produces(MediaType.APPLICATION_XML)
	public String getVersion() {
		return "<versao>1.0</versao>";
	}
	
	@GET
	@Path("{nome}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Nome> getByNome(@PathParam("nome") String nome) {
		return dao.buscar(nome);
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
	@Path("all/{date}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Nome> getAll(@PathParam("date") long timestamp) {
		return dao.lista(timestamp);
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

	@DELETE
	@Path("{id}/{date}")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response delNome(@PathParam("id") int num, @PathParam("date") long timestamp) {
		System.out.println("delNome: " + num + " - " + timestamp);
		dao.remover(num, timestamp);
		return Response.ok().build();
	}

	@GET
	@Path("count")
	@Produces(MediaType.APPLICATION_XML)
	public String getCount() {
		return "<registro><count>"+String.valueOf(dao.quantos())+"</count></registro>";
	}
}
