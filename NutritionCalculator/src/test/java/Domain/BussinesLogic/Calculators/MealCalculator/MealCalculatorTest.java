package Domain.BussinesLogic.Calculators.MealCalculator;

import Domain.Entities.MealData;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MealCalculatorTest {

    private Double MealWeightInGramsMock = 122.5d;

    private MealData MealDataMock = new MealData().Create(
            "test",
            100,
            10d,
            1d,
            5d
    );

    @Test
    void GivenMealCalculator_WhenGetMealCalories_ThenExpectedValue(){
        //Given
        var mealData = MealDataMock;
        var mealCalculator = new MealCalculator();

        //When
        var result = mealCalculator.GetCalories(mealData, MealWeightInGramsMock);

        //Then
        Assert.assertTrue(result.equals(123));
    }

    @Test
    void GivenMealCalculator_WhenGetMealCarbs_ThenExpectedValue(){
        //Given
        var mealData = MealDataMock;
        var mealCalculator = new MealCalculator();

        //When
        var result = mealCalculator.GetCarbs(mealData, MealWeightInGramsMock);

        //Then
        Assert.assertTrue(result.equals(12.3d));
    }

    @Test
    void GivenMealCalculator_WhenGetMealProteins_ThenExpectedValue(){
        //Given
        var mealData = MealDataMock;
        var mealCalculator = new MealCalculator();

        //When
        var result = mealCalculator.GetProteins(mealData, MealWeightInGramsMock);

        //Then
        Assert.assertTrue(result.equals(1.2d));
    }

    @Test
    void GivenMealCalculator_WhenGetMealFats_ThenExpectedValue(){
        //Given
        var mealData = MealDataMock;
        var mealCalculator = new MealCalculator();

        //When
        var result = mealCalculator.GetFats(mealData, MealWeightInGramsMock);

        //Then
        Assert.assertTrue(result.equals(6.1d));
    }
}