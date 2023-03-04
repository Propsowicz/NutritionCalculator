package Presentation.Controllers.ApplicationUser;

import Application.Commands.ApplicationUser.Create.ICreateApplicationUser;
import Presentation.Controllers.ApplicationUser.Request.ApplicationUserCreateRequest;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class ApplicationUserController {

    @Inject
    ICreateApplicationUser createUser;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response CreateUser(@Valid ApplicationUserCreateRequest request){

        return Response.ok(
            createUser.Handle(
                request.Email,
                request.Password)
        ).build();
    }
}
