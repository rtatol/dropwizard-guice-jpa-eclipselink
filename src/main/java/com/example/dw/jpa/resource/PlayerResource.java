package com.example.dw.jpa.resource;

import com.example.dw.jpa.entity.Player;
import com.example.dw.jpa.service.PlayerService;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/player")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {

    private final PlayerService playerService;

    @Inject
    public PlayerResource(final PlayerService playerService) {
        this.playerService = playerService;
    }

    @POST
    public Player addPlayer(@Valid Player player) {
        playerService.save(player);
        return player;
    }

    @GET
    @Path("/{id}")
    public Player getPlayer(@PathParam("id") Long id) {
        return playerService.findById(id);
    }

    @DELETE
    @Path("/{id}")
    public Response deletePlayer(@PathParam("id") Long id) {
        playerService.deleteById(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/find")
    public List<Player> getPlayerByName(@QueryParam("name") String name) {
        return playerService.findPlayerByName(Optional.ofNullable(name));
    }

    @GET
    public List<Player> getPlayerList() {
        return playerService.findAll();
    }
}
