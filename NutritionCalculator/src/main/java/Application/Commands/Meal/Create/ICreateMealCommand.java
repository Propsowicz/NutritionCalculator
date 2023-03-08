package Application.Commands.Meal.Create;

import Presentation.Controllers.Meal.Request.CreateMealRequest;

public interface ICreateMealCommand {
    String Handle(CreateMealRequest request);
}
