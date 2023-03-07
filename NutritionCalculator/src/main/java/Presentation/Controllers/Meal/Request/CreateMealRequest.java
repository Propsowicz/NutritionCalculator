package Presentation.Controllers.Meal.Request;

import Application.CustomValidators.IsApplicationUserExists.IsApplicationUserExists;
import Application.CustomValidators.IsMealDataExists.IsMealDataExists;
import Application.ValidationExceptionHandler.ValidationExceptionMessages;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.Length;

public class CreateMealRequest {
    @NotNull(message = ValidationExceptionMessages.NOT_NULL)
    @Length(max = 50, message = ValidationExceptionMessages.STRING_LENGTH_MAX_50)
    @IsApplicationUserExists
    public String ApplicationUserId;

    @NotNull(message = ValidationExceptionMessages.NOT_NULL)
    @Length(max = 50, message = ValidationExceptionMessages.STRING_LENGTH_MAX_50)
    @IsMealDataExists
    public String MealDataId;

    @PositiveOrZero(message = ValidationExceptionMessages.POSITIVE_OR_ZERO)
    @Max(value = 5000, message = ValidationExceptionMessages.INTEGER_MAX_5000)
    public Double MealWeightInGrams;

    public CreateMealRequest() {
    }

    public String getApplicationUserId() {
        return ApplicationUserId;
    }

    public void setApplicationUserId(String applicationUserId) {
        ApplicationUserId = applicationUserId;
    }

    public String getMealDataId() {
        return MealDataId;
    }

    public void setMealDataId(String mealDataId) {
        MealDataId = mealDataId;
    }

    public Double getMealWeightInGrams() {
        return MealWeightInGrams;
    }

    public void setMealWeightInGrams(Double mealWeightInGrams) {
        MealWeightInGrams = mealWeightInGrams;
    }
}
