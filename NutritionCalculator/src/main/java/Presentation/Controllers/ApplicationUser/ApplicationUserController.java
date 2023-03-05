package Presentation.Controllers.ApplicationUser;

import Application.Commands.ApplicationUser.Create.ICreateApplicationUserCommand;
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
    ICreateApplicationUserCommand createApplicationUserCommand;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response CreateApplicationUser(@Valid ApplicationUserCreateRequest request){

        return Response.ok(
            createApplicationUserCommand.Handle(
                request.Email,
                request.Password)
        ).build();
    }
}
