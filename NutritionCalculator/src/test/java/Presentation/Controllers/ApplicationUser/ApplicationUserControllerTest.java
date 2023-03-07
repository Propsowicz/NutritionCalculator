package Presentation.Controllers.ApplicationUser;

import Application.Commands.ApplicationUser.Create.CreateApplicationUserCommand;
import Application.Commands.ApplicationUser.Create.ICreateApplicationUserCommand;
import Application.Queries.User.GetAll.IGetAllUsers;
import Presentation.Controllers.ApplicationUser.Request.ApplicationUserCreateRequest;
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

class ApplicationUserControllerTest {
    @Mock
    ICreateApplicationUserCommand createUserMock = new CreateApplicationUserCommand();

    @Mock
    IGetAllUsers getAllUsersMock;

    @InjectMocks
    ApplicationUserController controllerMock;

    @Test
    void GivenApplicationUserController_WhenCreateUser_ThenOk() {
        //Given
        ApplicationUserCreateRequest requestMock = mock();
        when(createUserMock
            .Handle(requestMock.Email, requestMock.Password)
        )
        .thenReturn(UUID.randomUUID().toString());

        //When
        var response = controllerMock.CreateApplicationUser(requestMock);

        //Then
        Assert.assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
        Assert.assertTrue(response.getEntity().toString().length() == 36);
    }

    @Test
    void GivenApplicationUserController_WhenGetAllUsers_ThenOk() throws JsonProcessingException {
        //Given
        Integer pageNumberMock = 1;
        Integer pageSizeMock = 1;
        String orderValueMock = "test";
        String orderDirectionMock = "test";
        String phraseMock = "test";

        //When
        var response = controllerMock.GetAllUsers(
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