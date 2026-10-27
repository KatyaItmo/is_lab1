package org.example.is_lab1.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.is_lab1.daos.CoordinatesDao;
import org.example.is_lab1.entities.Coordinates;

import java.util.List;

@Path("/coordinates")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class CoordinatesController {

    @Inject
    private CoordinatesDao coordinatesDao;

    @GET
    public List<Coordinates> getAllCoordinates() {
        return coordinatesDao.findAll();
    }

    @POST
    public Response createCoordinates(Coordinates coordinates) {
        Coordinates created = coordinatesDao.create(coordinates);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }
}