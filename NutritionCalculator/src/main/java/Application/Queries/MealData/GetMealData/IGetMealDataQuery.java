package Application.Queries.MealData.GetMealData;

import Application.Queries.MealData.DtoModels.MealDataDto;
import Application.Primitives.PaginatedResponse;

public interface IGetMealDataQuery {
    PaginatedResponse<MealDataDto> Handle(
            Integer pageNumber,
            Integer pageSize
    );
}
