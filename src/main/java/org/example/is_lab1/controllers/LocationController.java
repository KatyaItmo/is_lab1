package org.example.is_lab1.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.is_lab1.auth.UserService;
import org.example.is_lab1.daos.LocationDao;
import org.example.is_lab1.entities.Location;

import java.util.List;

@Path("/locations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class LocationController {

    @Inject
    private LocationDao locationDao;

    @Inject
    private UserService userService;

    @GET
    public List<Location> getAllLocations() {
        return locationDao.findAll();
    }

    @POST
    public Response createLocation(
            @CookieParam("SESSION_TOKEN") String sessionToken,
            Location location) {
        userService.validateSession(sessionToken);
        Location created = locationDao.create(location);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }
}