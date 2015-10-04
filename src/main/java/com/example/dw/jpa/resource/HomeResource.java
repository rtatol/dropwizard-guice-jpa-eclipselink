package com.example.dw.jpa.resource;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class HomeResource {

    @GET
    @Timed
    public HelloMessage hello() {
        return new HelloMessage("Hello");
    }

    class HelloMessage {

        private final String message;

        public HelloMessage(final String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
