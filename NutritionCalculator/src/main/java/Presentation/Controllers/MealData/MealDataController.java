package Presentation.Controllers.MealData;

import Application.Commands.MealData.Create.ICreateMealDataCommand;
import Application.Queries.MealData.GetMealData.IGetMealDataQuery;
import Presentation.BuidlingBlocks.Helpers.JsonSerializer;
import Presentation.BuidlingBlocks.Primitives.PaginatedRequest;
import Presentation.Controllers.MealData.Request.MealDataCreateRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetMealData(
        @QueryParam("page-number") Integer pageNumber,
        @QueryParam("page-size") Integer pageSize,
        @QueryParam("ord-val") String orderValue,
        @QueryParam("ord-dir") String orderDirection,
        @QueryParam("phrase") String phrase
    ) throws JsonProcessingException {
        return Response.ok(
            JsonSerializer.Serialize(
                getMealDataQuery.Handle(
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
