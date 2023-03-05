package Domain.Entities;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealDataTest {

    @Test
    void GivenMealData_WhenCreate_ThenSucceed() {
        //Given
        String name = "test";
        Integer calories = 120;
        Double carbs = 21d;
        Double fats = 22d;
        Double proteins = 23d;

        //When
        var mealData = new MealData().Create(
                name,
                calories,
                carbs,
                proteins,
                fats
        );

        //Then
        Assert.assertTrue(mealData.Name.equals(name));
        Assert.assertTrue(mealData.CaloriesPer100Grams.equals(calories));
        Assert.assertTrue(mealData.ProteinsPer100Grams.equals(proteins));
        Assert.assertTrue(mealData.CarbsPer100Grams.equals(carbs));
        Assert.assertTrue(mealData.FatsPer100Grams.equals(fats));
    }
}