package org.example.is_lab1.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class OccupiedUsernameExceptionMapper implements ExceptionMapper<OccupiedUsernameException> {

    @Override
    public Response toResponse(OccupiedUsernameException exception) {
        String jsonError = "{\"error\": \"" + exception.getMessage() + "\"}";

        return Response.status(Response.Status.CONFLICT)
                .entity(jsonError)
                .type("application/json")
                .build();
    }
}
