package Domain.BussinesLogic.Calculators.MealCalculator;

import Domain.Entities.MealData;

public interface IMealCalculator {
    Integer GetCalories(MealData mealData, Double mealWeightInGrams);

    Double GetCarbs(MealData mealData, Double mealWeightInGrams);

    Double GetProteins(MealData mealData, Double mealWeightInGrams);

    Double GetFats(MealData mealData, Double mealWeightInGrams);
}
