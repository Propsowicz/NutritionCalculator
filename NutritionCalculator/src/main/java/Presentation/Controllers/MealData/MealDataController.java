package Presentation.Controllers.MealData;

import Application.Commands.MealData.Create.ICreateMealDataCommand;
import Application.Queries.MealData.GetMealData.IGetMealDataQuery;
import Presentation.Controllers.MealData.Request.MealDataCreateRequest;
import Presentation.Helpers.JsonSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/meal-data")
public class MealDataController {

    @Inject
    ICreateMealDataCommand createMealDataCommand;

    @Inject
    IGetMealDataQuery getMealDataQuery;

    @GET
    @Path("/page-number={pageNumber}&page-size={pageSize}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetMealData(
        @PathParam("pageNumber") @Positive Integer pageNumber,
        @PathParam("pageSize") @Positive @Max(20) Integer pageSize
    ) throws JsonProcessingException {
        return Response.ok(
            JsonSerializer.Serialize(
                getMealDataQuery.Handle(
                    pageNumber,
                    pageSize
                )
            )
        ).build();
    }

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
