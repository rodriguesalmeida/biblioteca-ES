package biblioteca.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import biblioteca.bean.LivroBean;
import biblioteca.model.Livro;

@Path("livro")
public class LivroRest {

	@EJB
	private LivroBean livroBean;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserir(Livro livro) {
		try {
			livro = livroBean.inserir(livro);
			return Response.ok(livro).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorId(@PathParam("id")Long id) {
		try {
			Livro livro = livroBean.buscarPorId(id);
			return Response.ok(livro).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
}
