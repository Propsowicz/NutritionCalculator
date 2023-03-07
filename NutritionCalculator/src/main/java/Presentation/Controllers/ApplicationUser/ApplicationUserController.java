package Presentation.Controllers.ApplicationUser;

import Application.Commands.ApplicationUser.Create.ICreateApplicationUserCommand;
import Application.Queries.User.GetAll.IGetAllUsers;
import Presentation.BuidlingBlocks.Helpers.JsonSerializer;
import Presentation.BuidlingBlocks.Primitives.PaginatedRequest;
import Presentation.Controllers.ApplicationUser.Request.ApplicationUserCreateRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class ApplicationUserController {

    @Inject
    ICreateApplicationUserCommand createApplicationUserCommand;

    @Inject
    IGetAllUsers getAllUsers;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetAllUsers(
            @QueryParam("page-number") Integer pageNumber,
            @QueryParam("page-size") Integer pageSize,
            @QueryParam("ord-val") String orderValue,
            @QueryParam("ord-dir") String orderDirection,
            @QueryParam("phrase") String phrase
    ) throws JsonProcessingException {
        return Response.ok(
            JsonSerializer.Serialize(
                getAllUsers.Handle(
                    new PaginatedRequest(
                        pageNumber,
                        pageSize,
                        orderValue,
                        orderDirection,
                        phrase
                    )
                )
            )
        ).build();
    }

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
