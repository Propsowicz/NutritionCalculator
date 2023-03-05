package Presentation.Controllers.MealData;

import Application.Commands.MealData.Create.CreateMealDataCommand;
import Application.Commands.MealData.Create.ICreateMealDataCommand;
import Presentation.Controllers.MealData.Request.MealDataCreateRequest;
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
class MealDataControllerTest {

    @Mock
    ICreateMealDataCommand createMealDataCommandMock = new CreateMealDataCommand();

    @InjectMocks
    MealDataController controller;

    @Test
    void GivenMealDataController_WhenCreateMealData_ThenOk() {
        //Given
        MealDataCreateRequest requestMock = mock();
        when(createMealDataCommandMock
                .Handle(
                    requestMock.Name,
                    requestMock.CaloriesPer100Grams,
                    requestMock.ProteinsPer100Grams,
                    requestMock.CarbsPer100Grams,
                    requestMock.FatsPer100Grams
                ))
                .thenReturn(UUID.randomUUID().toString());

        //When
        var response = controller.CreateMealData(requestMock);

        //Then
        Assert.assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
        Assert.assertTrue(response.getEntity().toString().length() == 36);
    }
}