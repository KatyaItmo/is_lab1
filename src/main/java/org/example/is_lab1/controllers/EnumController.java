package org.example.is_lab1.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.is_lab1.entities.*;

@Path("/enums")
@Produces(MediaType.APPLICATION_JSON)
public class EnumController {

    @GET
    @Path("/positions")
    public Response getPositions() {
        return Response.ok(Position.values()).build();
    }

    @GET
    @Path("/organization-types")
    public Response getOrganizationTypes() {
        return Response.ok(OrganizationType.values()).build();
    }

    @GET
    @Path("/statuses")
    public Response getStatuses() {
        return Response.ok(Status.values()).build();
    }

    @GET
    @Path("/countries")
    public Response getCountries() {
        return Response.ok(Country.values()).build();
    }
}