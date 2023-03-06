package Presentation.BuidlingBlocks.Primitives;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderDirectionsTest {

    @Test
    void GivenOrderDirections_WhenHandle_ThenReturnAscValue() {
        //Given
        var orderDirectoryMock = "asc";

        //When
        var result = OrderDirections.Handle(orderDirectoryMock);

        //Then
        Assert.assertTrue(result.equals(orderDirectoryMock));
    }

    @Test
    void GivenOrderDirections_WhenHandle_ThenReturnDescValue() {
        //Given
        var orderDirectoryMock = "desc";

        //When
        var result = OrderDirections.Handle(orderDirectoryMock);

        //Then
        Assert.assertTrue(result.equals(orderDirectoryMock));
    }

    @Test
    void GivenOrderDirections_WhenHandle_ThenReturnDefaultValue() {
        //Given
        var orderDirectoryMock = "";

        //When
        var result = OrderDirections.Handle(orderDirectoryMock);

        //Then
        Assert.assertTrue(result.equals("asc"));
    }
}