package Application.AuthFactory;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordHasherTest {

    @Test
    void GivenPasswordHasher_WhenHash_ThenSucceed() {
        //Given
        var password = "test";

        //When
        var result = PasswordHasher.Hash(password);

        //Then
        Assert.assertFalse(result.equals(password));
    }
}