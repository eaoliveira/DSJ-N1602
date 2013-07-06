package projetoWeb.servico;

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

import projetoWeb.modelo.Produto;

@Path("produto")
public class ProdutoBean {
	private ProdutoService dao = ProdutoService.getInstance();

	@GET
	@Path("version")
	@Produces(MediaType.TEXT_PLAIN)
	public String version() {
		return "Produto Bean 1.0 - test";
	}

	@GET
	@Path("{nome}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Produto> getByProduto(@PathParam("nome") String nome) {
		return dao.buscar(nome);
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Produto addProduto(JAXBElement<Produto> obj) {
		Produto n = obj.getValue();
		return dao.salvar(n);
	}

	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateProduto(JAXBElement<Produto> obj) {
		Produto n = obj.getValue();
		if(dao.atualizar(n))
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_XML)
	public List<Produto> getAll() {
		return dao.listaTodos();
	}

	@GET
	@Path("key/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Produto getById(@PathParam("id") int num) {
		return dao.buscar(num);
	}

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response delProduto(@PathParam("id") int num) {
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
