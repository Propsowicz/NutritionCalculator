package Domain.BussinesLogic.Calculators.MealCalculator;

import Domain.BuildingBlocks.Helpers.MathMethods;
import Domain.Entities.MealData;
import jakarta.ejb.Stateless;

@Stateless
public class MealCalculator implements IMealCalculator {

    @Override
    public Integer GetCalories(MealData mealData, Double mealWeightInGrams) {
        return MathMethods.Round(CalculateWeightRatio(mealWeightInGrams) * mealData.CaloriesPer100Grams, 0).intValue();
    }

    @Override
    public Double GetCarbs(MealData mealData, Double mealWeightInGrams) {
        return MathMethods.Round(CalculateWeightRatio(mealWeightInGrams) * mealData.CarbsPer100Grams, 1);
    }

    @Override
    public Double GetProteins(MealData mealData, Double mealWeightInGrams) {
        return MathMethods.Round(CalculateWeightRatio(mealWeightInGrams) * mealData.ProteinsPer100Grams, 1);
    }

    @Override
    public Double GetFats(MealData mealData, Double mealWeightInGrams) {
        return MathMethods.Round(CalculateWeightRatio(mealWeightInGrams) * mealData.FatsPer100Grams, 1);
    }

    private Double CalculateWeightRatio(Double mealWeightInGrams){
        return mealWeightInGrams / 100;
    }
}
