package Presentation.Controllers.MealData;

import Application.Commands.MealData.Create.ICreateMealDataCommand;
import Presentation.Controllers.MealData.Request.MealDataCreateRequest;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/meal-data")
public class MealDataController {

    @Inject
    ICreateMealDataCommand createMealDataCommand;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response CreateMealData(@Valid MealDataCreateRequest request){
        return Response.ok(
            createMealDataCommand.Handle(
                request.Name,
                request.CaloriesPer100Grams,
                request.CarbsPer100Grams,
                request.ProteinsPer100Grams,
                request.FatsPer100Grams
            )
        ).build();
    }
}
