package org.example.is_lab1.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.is_lab1.dtos.OrganizationDto;
import org.example.is_lab1.services.OrganizationService;

import java.util.List;

@Path("/organizations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class OrganizationController {

    @Inject
    private OrganizationService organizationService;

    @GET
    public List<OrganizationDto> getAllOrganizations() {
        return organizationService.findAll();
    }

    @POST
    public Response createOrganization(OrganizationDto dto) {
        OrganizationDto created = organizationService.create(dto);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }
}