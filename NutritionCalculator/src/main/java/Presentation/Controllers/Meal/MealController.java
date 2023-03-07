package Presentation.Controllers.Meal;

import Application.Commands.Meal.Create.ICreateMealCommand;
import Presentation.Controllers.Meal.Request.CreateMealRequest;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/meals")
public class MealController {

    @Inject
    ICreateMealCommand createMealCommand;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response CreateMeal(@Valid CreateMealRequest request){
        return Response.ok(
                createMealCommand.Handle(request)
        ).build();
    }
}
