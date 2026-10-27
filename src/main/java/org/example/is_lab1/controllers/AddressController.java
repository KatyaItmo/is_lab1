package org.example.is_lab1.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.is_lab1.auth.UserService;
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

    @Inject
    private UserService userService;

    @GET
    public List<AddressDto> getAllAddresses() {
        return addressService.findAll();
    }

    @POST
    public Response createAddress(
            @CookieParam("SESSION_TOKEN") String sessionToken,
            AddressDto dto) {
        userService.validateSession(sessionToken);
        AddressDto created = addressService.create(dto);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }
}