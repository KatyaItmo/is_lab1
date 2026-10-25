package org.example.is_lab1.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.is_lab1.entities.Address;
import org.example.is_lab1.services.AddressService;

import java.util.List;

@Path("/addresses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressController {

    @Inject
    private AddressService addressService;

    @GET
    public Response getAll() {
        List<Address> addresses = addressService.findAll();
        return Response.ok(addresses).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) {
        Address address = addressService.findById(id);
        return Response.ok(address).build();
    }

    @POST
    public Response create(Address address) {
        Address created = addressService.create(address);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }
}