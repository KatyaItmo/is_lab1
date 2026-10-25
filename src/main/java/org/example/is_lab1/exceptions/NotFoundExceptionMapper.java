package org.example.is_lab1.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException exception) {
        String jsonError = "{\"error\": \"" + exception.getMessage() + "\"}";

        return Response.status(Response.Status.NOT_FOUND)
                .entity(jsonError)
                .type("application/json")
                .build();
    }
}
