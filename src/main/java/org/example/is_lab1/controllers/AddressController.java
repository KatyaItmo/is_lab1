package org.example.is_lab1.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.is_lab1.dtos.AddressDto;
import org.example.is_lab1.services.AddressService;

import java.util.List;

@Path("/addresses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class AddressController {

    @Inject
    private AddressService addressService;

    @GET
    public List<AddressDto> getAllAddresses() {
        return addressService.findAll();
    }

    @POST
    public Response createAddress(AddressDto dto) {
        AddressDto created = addressService.create(dto);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }
}