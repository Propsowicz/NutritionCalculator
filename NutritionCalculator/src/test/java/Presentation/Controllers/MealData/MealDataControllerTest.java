package Presentation.Controllers.MealData;

import Application.Commands.MealData.Create.CreateMealDataCommand;
import Application.Commands.MealData.Create.ICreateMealDataCommand;
import Application.Queries.MealData.GetMealData.IGetMealDataQuery;
import Presentation.Controllers.MealData.Request.MealDataCreateRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ws.rs.core.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MealDataControllerTest {

    @Mock
    ICreateMealDataCommand createMealDataCommandMock = new CreateMealDataCommand();

    @Mock
    IGetMealDataQuery getMealDataQueryMock;

    @InjectMocks
    MealDataController controllerMock;

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
                )
        )
        .thenReturn(UUID.randomUUID().toString());

        //When
        var response = controllerMock.CreateMealData(requestMock);

        //Then
        Assert.assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
        Assert.assertTrue(response.getEntity().toString().length() == 36);
    }

    @Test
    void GivenMealDataController_WhenGetMealData_ThenOk() throws JsonProcessingException {
        //Given
        Integer pageNumberMock = 1;
        Integer pageSizeMock = 1;
        String orderValueMock = "test";
        String orderDirectionMock = "test";
        String phraseMock = "test";

        //When
        var response = controllerMock.GetMealData(
                pageNumberMock,
                pageSizeMock,
                orderValueMock,
                orderDirectionMock,
                phraseMock
        );

        //Then
        Assert.assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
        Assert.assertTrue(response.getEntity() instanceof String);
    }
}