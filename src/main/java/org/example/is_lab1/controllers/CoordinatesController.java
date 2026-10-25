package org.example.is_lab1.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.is_lab1.daos.CoordinatesDao;
import org.example.is_lab1.entities.Coordinates;
import org.example.is_lab1.exceptions.NotFoundException;

import java.util.List;

@Path("/coordinates")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoordinatesController {

    @Inject
    private CoordinatesDao coordinatesDao;

    @GET
    public Response getAll() {
        List<Coordinates> list = coordinatesDao.findAll();
        return Response.ok(list).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) {
        Coordinates coord = coordinatesDao.findById(id)
                .orElseThrow(() -> new NotFoundException("coordinates с id " + id + " не найдены"));
        return Response.ok(coord).build();
    }

    @POST
    public Response create(Coordinates coordinates) {
        Coordinates created = coordinatesDao.create(coordinates);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }
}