package Application.Queries.MealData.GetMealData;

import Application.BuildingBlocks.Primitives.PaginatedResponse;
import Application.Queries.MealData.DtoModels.MealDataDto;
import Presentation.BuidlingBlocks.Primitives.PaginatedRequest;

public interface IGetMealDataQuery {
    PaginatedResponse<MealDataDto> Handle(PaginatedRequest request);
}
