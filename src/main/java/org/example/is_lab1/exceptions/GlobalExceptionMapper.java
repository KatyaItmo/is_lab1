package org.example.is_lab1.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        String jsonError = "{\"error\": \"внутренняя ошибка сервера: " + exception.getMessage() + "\"}";

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(jsonError)
                .type("application/json")
                .build();
    }
}
