package org.example.is_lab1.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.is_lab1.auth.UserService;
import org.example.is_lab1.dtos.PersonDto;
import org.example.is_lab1.services.PersonService;

import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class PersonController {

    @Inject
    private PersonService personService;

    @Inject
    private UserService userService;

    @GET
    public List<PersonDto> getAllPersons() {
        return personService.findAll();
    }

    @POST
    public Response createPerson(
            @CookieParam("SESSION_TOKEN") String sessionToken,
            PersonDto dto) {
        userService.validateSession(sessionToken);
        PersonDto created = personService.create(dto);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }
}