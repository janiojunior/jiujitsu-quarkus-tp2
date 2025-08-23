package br.unitins.tp2.jiujitsu.resource;

import java.util.ArrayList;
import java.util.List;

import br.unitins.tp2.jiujitsu.model.Estado;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/estados")
public class EstadoResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Estado> list = new ArrayList<Estado>();
        list.add(new Estado("Tocantins", "TO"));
        list.add(new Estado("Goiás", "GO"));
        list.add(new Estado("São Paulo", "SP"));
        list.add(new Estado("Rio de Janeiro", "RJ"));
        
        return Response.ok(list).build();
    }
}
