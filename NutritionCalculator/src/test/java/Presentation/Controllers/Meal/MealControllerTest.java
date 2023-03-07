package Presentation.Controllers.Meal;

import Application.Commands.Meal.Create.CreateMealCommand;
import Application.Commands.Meal.Create.ICreateMealCommand;
import Presentation.Controllers.Meal.Request.CreateMealRequest;
import jakarta.ws.rs.core.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MealControllerTest {

    @Mock
    ICreateMealCommand createMealCommandMock = new CreateMealCommand();

    @InjectMocks
    MealController controllerMock;

    @Test
    void GivenMealController_WhenCreateMeal_ThenOk() {
        //Given
        CreateMealRequest requestMock = mock();
        when(createMealCommandMock
                .Handle(requestMock)
        )
        .thenReturn(UUID.randomUUID().toString());

        //When
        var response = controllerMock.CreateMeal(requestMock);

        //Then
        Assert.assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
        Assert.assertTrue(response.getEntity().toString().length() == 36);
    }
}