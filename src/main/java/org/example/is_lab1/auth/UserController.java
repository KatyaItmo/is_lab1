package org.example.is_lab1.auth;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/auth")
public class UserController {

    @Inject
    private UserService userService;

    @POST
    @Path("/register")
    public Response register(UserDto userDto) {
        User createdUser = userService.register(userDto);

        return Response.status(Response.Status.CREATED)
                .entity(createdUser)
                .build();
    }

    @POST
    @Path("/login")
    public Response login(UserDto userDto) {
        User user = userService.login(userDto);

        String token = user.getSessionToken();

        NewCookie cookie = new NewCookie(
                "SESSION_TOKEN",
                token,
                "/",
                "",
                "",
                3600,
                false,
                true
        );

        return Response.ok(user)
                .cookie(cookie)
                .build();
    }

    @POST
    @Path("/logout")
    public Response logout(@CookieParam("SESSION_TOKEN") String token) {
        userService.logout(token);

        NewCookie expiredCookie = new NewCookie(
                "SESSION_TOKEN",
                "",
                "/",
                "",
                "",
                0,
                false,
                true
        );

        return Response.ok("{\"message\": \"вы вышли из аккаунта\"}")
                .cookie(expiredCookie)
                .build();
    }
}
