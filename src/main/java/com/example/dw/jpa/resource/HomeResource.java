package com.example.dw.jpa.resource;

import com.codahale.metrics.annotation.Timed;
import com.example.dw.jpa.config.Config;
import com.example.dw.jpa.core.HelloMessage;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class HomeResource {

    private final Config configuration;

    @Inject
    public HomeResource(final Config configuration) {
        this.configuration = configuration;
    }

    @GET
    @Timed
    public HelloMessage hello() {
        return new HelloMessage(configuration.getMessage());
    }
}
