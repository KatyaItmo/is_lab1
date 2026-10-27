package org.example.is_lab1.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class IllegalPasswordExceptionMapper implements ExceptionMapper<IllegalPasswordException> {

    @Override
    public Response toResponse(IllegalPasswordException exception) {
        String jsonError = "{\"error\": \"" + exception.getMessage() + "\"}";

        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(jsonError)
                .type("application/json")
                .build();
    }
}
