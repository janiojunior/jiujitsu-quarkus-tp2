package br.unitins.tp2.jiujitsu.resource;

import java.net.URI;

import br.unitins.tp2.jiujitsu.dto.PlanoDTO;
import br.unitins.tp2.jiujitsu.dto.PlanoResponseDTO;
import br.unitins.tp2.jiujitsu.service.PlanoService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/planos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlanoResource {

    private static final int MAX_PAGE_SIZE = 100;

    @Inject
    PlanoService service;

    @GET
    public Response buscarTodos(@QueryParam("page")     @DefaultValue("0")   int page,
                                @QueryParam("pageSize") @DefaultValue("100") int pageSize) {
        page = Math.max(0, page);
        pageSize = Math.min(Math.max(1, pageSize), MAX_PAGE_SIZE);

        return Response.ok(service.getAll(page, pageSize))
                .header("X-Page", page)
                .header("X-Page-Size", pageSize)
                .header("X-Total-Count", service.count()) 
                .build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response buscarPorNome(@PathParam("nome") String nome,
                                  @QueryParam("page")     @DefaultValue("0")   int page,
                                  @QueryParam("pageSize") @DefaultValue("100") int pageSize) {
        page = Math.max(0, page);
        pageSize = Math.min(Math.max(1, pageSize), MAX_PAGE_SIZE);

        return Response.ok(service.findByNome(nome, page, pageSize))
                .header("X-Page", page)
                .header("X-Page-Size", pageSize)
                .header("X-Total-Count", service.countNome(nome)) 
                .build();
    }

    @GET
    @Path("/{id: \\d+}")
    public Response buscarPorId(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @POST
    public Response incluir(@Valid PlanoDTO dto, @Context UriInfo uriInfo) {
        PlanoResponseDTO created = service.create(dto);
        URI location = UriBuilder.fromResource(PlanoResource.class)
                                 .path(PlanoResource.class, "buscarPorId")
                                 .build(created.id());
        return Response.created(location).entity(created).build();
    }

    @PUT
    @Path("/{id: \\d+}")
    public Response alterar(@Valid PlanoDTO dto, @PathParam("id") Long id) {
        PlanoResponseDTO updated = service.update(id, dto);
        return Response.ok(updated).build(); // ou 204 sem corpo, se preferir
    }

    @DELETE
    @Path("/{id: \\d+}")
    public Response apagar(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }

    // pode manter para debug, mas com headers de paginação costuma ficar redundante
    @GET
    @Path("/count")
    public long total() {
        return service.count();
    }
}
