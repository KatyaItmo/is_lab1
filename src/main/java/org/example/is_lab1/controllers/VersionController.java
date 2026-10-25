package org.example.is_lab1.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/version")
@Produces(MediaType.APPLICATION_JSON)
public class VersionController {

    @GET
    public Response getVersion() {
        return Response.ok("{\"version\": \"1.0.0\"}").build();
    }
}
