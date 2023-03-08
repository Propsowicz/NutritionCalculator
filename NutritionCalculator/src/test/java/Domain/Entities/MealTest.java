package Domain.Entities;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MealTest {
    @Test
    void GivenMeal_WhenCreate_ThenSucceed() {
        //Given
        ApplicationUser applicationUserMock = new ApplicationUser().Create(
                "test",
                "test"
        );
        MealData mealDataMock = mock();
        var dateMock = LocalDate.now();
        var weightMock = 150d;
        var caloriesMock = 150;
        var carbsMock = 15d;
        var proteinsMock = 15d;
        var fatsMock = 15d;

        //When
        var result = new Meal().Create(
            applicationUserMock,
            mealDataMock,
            dateMock,
            weightMock,
            caloriesMock,
            carbsMock,
            proteinsMock,
            fatsMock
        );

        //Then
        Assert.assertTrue(result.getMealData().equals(mealDataMock));
        Assert.assertTrue(result.getApplicationUser().equals(applicationUserMock));
        Assert.assertTrue(result.Date.equals(dateMock));
        Assert.assertTrue(result.Weight.equals(weightMock));
        Assert.assertTrue(result.Calories.equals(caloriesMock));
        Assert.assertTrue(result.Carbs.equals(carbsMock));
        Assert.assertTrue(result.Proteins.equals(proteinsMock));
        Assert.assertTrue(result.Fats.equals(fatsMock));

        Assert.assertTrue(result.Id.length() == 36);
        Assert.assertTrue(result.CreatedById.equals(applicationUserMock.Id));
        Assert.assertTrue(result.getCreatedOn() instanceof LocalDate);
    }
}