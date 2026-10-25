package org.example.is_lab1.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.is_lab1.entities.Organization;
import org.example.is_lab1.services.OrganizationService;

import java.util.List;

@Path("/organizations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrganizationController {

    @Inject
    private OrganizationService organizationService;

    @GET
    public Response getAll() {
        List<Organization> orgs = organizationService.findAll();
        return Response.ok(orgs).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) {
        Organization org = organizationService.findById(id);
        return Response.ok(org).build();
    }

    @POST
    public Response create(Organization organization) {
        Organization created = organizationService.create(organization);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }
}