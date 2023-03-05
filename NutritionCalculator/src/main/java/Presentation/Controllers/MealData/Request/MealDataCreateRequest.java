package Presentation.Controllers.MealData.Request;

import Application.ValidationExceptionHandler.ValidationExceptionMessages;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.Length;

public class MealDataCreateRequest {
    @NotNull(message = ValidationExceptionMessages.NOT_NULL)
    @Length(max = 50, message = ValidationExceptionMessages.STRING_LENGTH_MAX_50)
    public String Name;

    @PositiveOrZero(message = ValidationExceptionMessages.POSITIVE_OR_ZERO)
    @Max(value = 5000, message = ValidationExceptionMessages.INTEGER_MAX_5000)
    public Integer CaloriesPer100Grams;

    @PositiveOrZero(message = ValidationExceptionMessages.POSITIVE_OR_ZERO)
    @Max(value = 5000, message = ValidationExceptionMessages.INTEGER_MAX_5000)
    public Double CarbsPer100Grams;

    @PositiveOrZero(message = ValidationExceptionMessages.POSITIVE_OR_ZERO)
    @Max(value = 5000, message = ValidationExceptionMessages.INTEGER_MAX_5000)
    public Double ProteinsPer100Grams;

    @PositiveOrZero(message = ValidationExceptionMessages.POSITIVE_OR_ZERO)
    @Max(value = 5000, message = ValidationExceptionMessages.INTEGER_MAX_5000)
    public Double FatsPer100Grams;

    public MealDataCreateRequest() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getCaloriesPer100Grams() {
        return CaloriesPer100Grams;
    }

    public void setCaloriesPer100Grams(Integer caloriesPer100Grams) {
        CaloriesPer100Grams = caloriesPer100Grams;
    }

    public Double getCarbsPer100Grams() {
        return CarbsPer100Grams;
    }

    public void setCarbsPer100Grams(Double carbsPer100Grams) {
        CarbsPer100Grams = carbsPer100Grams;
    }

    public Double getProteinsPer100Grams() {
        return ProteinsPer100Grams;
    }

    public void setProteinsPer100Grams(Double proteinsPer100Grams) {
        ProteinsPer100Grams = proteinsPer100Grams;
    }

    public Double getFatsPer100Grams() {
        return FatsPer100Grams;
    }

    public void setFatsPer100Grams(Double fatsPer100Grams) {
        FatsPer100Grams = fatsPer100Grams;
    }
}
