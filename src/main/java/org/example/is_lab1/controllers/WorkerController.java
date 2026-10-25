package org.example.is_lab1.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.is_lab1.entities.Worker;
import org.example.is_lab1.services.WorkerService;

import java.util.List;

@Path("/workers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WorkerController {

    @Inject
    private WorkerService workerService;

    @GET
    public Response getAll() {
        List<Worker> workers = workerService.findAll();
        return Response.ok(workers).build();
    }

    @POST
    public Response create(Worker worker) {
        Worker createdWorker = workerService.create(worker);
        return Response.status(Response.Status.CREATED).entity(createdWorker).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) {
        Worker worker = workerService.findById(id);
        return Response.ok(worker).build();
    }
}
