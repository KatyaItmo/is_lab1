package org.example.is_lab1.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.is_lab1.entities.Person;
import org.example.is_lab1.services.PersonService;

import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {

    @Inject
    private PersonService personService;

    @GET
    public Response getAll() {
        List<Person> persons = personService.findAll();
        return Response.ok(persons).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) {
        Person person = personService.findById(id);
        return Response.ok(person).build();
    }

    @POST
    public Response create(Person person) {
        Person created = personService.create(person);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }
}