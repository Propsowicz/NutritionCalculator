package Domain.Entities;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationUserControllerTest {

    @Test
    void GivenApplicationUser_WhenCreate_ThenSucceed() {
        //Given
        String email = "test@test.com";
        String password = "test";

        //When
        var result = new ApplicationUser().Create(email, password);

        //Then
        Assert.assertTrue(result.Email.equals(email));
        Assert.assertTrue(result.Password.equals(password));
        Assert.assertTrue(result.Id.length() == 36);
    }
}