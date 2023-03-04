package Domain.Entities;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
        Assert.assertTrue(result.getCreatedOn() instanceof LocalDate);
        Assert.assertTrue(result.CreatedById.equals(result.getId()));
    }
}