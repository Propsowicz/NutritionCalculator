package Presentation.Controllers.ApplicationUser;

import Application.Commands.ApplicationUser.Create.CreateApplicationUser;
import Application.Commands.ApplicationUser.Create.ICreateApplicationUser;
import Presentation.Controllers.ApplicationUser.Request.ApplicationUserCreateRequest;
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
    ICreateApplicationUser createUserMock = new CreateApplicationUser();

    @InjectMocks
    ApplicationUserController controller;

    @Test
    void GivenApplicationUserController_WhenCreateUser_ThenOk() {
        //Given
        ApplicationUserCreateRequest requestMock = mock();
        when(createUserMock
            .Handle(requestMock.Email, requestMock.Password))
            .thenReturn(UUID.randomUUID().toString());

        //When
        var response = controller.CreateUser(requestMock);

        //Then
        Assert.assertTrue(response.getStatus() == 200);
        Assert.assertTrue(response.getEntity().toString().length() == 36);
    }
}