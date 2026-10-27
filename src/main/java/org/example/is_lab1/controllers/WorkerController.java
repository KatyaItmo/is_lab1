package org.example.is_lab1.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.is_lab1.dtos.WorkerDto;
import org.example.is_lab1.dtos.WorkerFilterDto;
import org.example.is_lab1.entities.Status;
import org.example.is_lab1.entities.Worker;
import org.example.is_lab1.services.WorkerService;

import java.util.List;

@Path("/workers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class WorkerController {

    @Inject
    private WorkerService workerService;

    @GET
    public List<WorkerDto> getWorkers(
            @QueryParam("name") String name,
            @QueryParam("sort") String sortDirection
    ) {
        WorkerFilterDto filter = new WorkerFilterDto();
        filter.setName(name);
        filter.setSortDirection(sortDirection);
        return workerService.getFilteredAndSortedWorkers(filter);
    }

    @GET
    @Path("/{id}")
    public Worker getWorkerById(@PathParam("id") Integer id) {
        return workerService.getWorkerEntityById(id);
    }

    @POST
    public Response createWorker(WorkerDto dto) {
        WorkerDto created = workerService.createWorker(dto);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    public WorkerDto updateWorker(@PathParam("id") Integer id, WorkerDto dto) {
        return workerService.updateWorker(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteWorker(@PathParam("id") Integer id) {
        workerService.deleteWorker(id);
        return Response.noContent().build();
    }


    @GET
    @Path("/special/average-rating")
    public Double getAverageRating() {
        return workerService.getAverageRating();
    }

    @GET
    @Path("/special/count-status-less")
    public Long countStatusLessThan(@QueryParam("status") Status status) {
        return workerService.countByStatusLessThan(status);
    }

    @GET
    @Path("/special/unique-statuses")
    public List<Status> getUniqueStatuses() {
        return workerService.getUniqueStatuses();
    }

    @POST
    @Path("/{id}/special/fire")
    public WorkerDto fireWorker(@PathParam("id") Integer id) {
        return workerService.fireWorker(id);
    }

    @POST
    @Path("/{id}/special/index-salary")
    public WorkerDto indexSalary(
            @PathParam("id") Integer id,
            @QueryParam("coefficient") double coefficient
    ) {
        return workerService.indexSalary(id, coefficient);
    }
}