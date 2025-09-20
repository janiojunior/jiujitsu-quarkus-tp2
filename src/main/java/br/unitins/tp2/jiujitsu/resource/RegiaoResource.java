package br.unitins.tp2.jiujitsu.resource;

import br.unitins.tp2.jiujitsu.model.Regiao;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("regioes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegiaoResource {

    @GET
    public Regiao[] buscarTodos() { 
        return Regiao.values();
    }

    @GET
    @Path("/{id}")
    public Regiao buscarPorId(@PathParam("id") Long id) {
        return Regiao.valueOf(id);
    }

}
