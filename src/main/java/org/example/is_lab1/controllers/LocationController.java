package org.example.is_lab1.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.is_lab1.daos.LocationDao;
import org.example.is_lab1.entities.Location;
import org.example.is_lab1.exceptions.NotFoundException;

import java.util.List;

@Path("/locations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LocationController {

    @Inject
    private LocationDao locationDao;

    @GET
    public Response getAll() {
        List<Location> list = locationDao.findAll();
        return Response.ok(list).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) {
        Location location = locationDao.findById(id)
                .orElseThrow(() -> new NotFoundException("location с id " + id + " не найдена"));
        return Response.ok(location).build();
    }

    @POST
    public Response create(Location location) {
        Location created = locationDao.create(location);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }
}