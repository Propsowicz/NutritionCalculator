package Presentation.BuidlingBlocks.Primitives;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaginatedRequestTest {

    @Test
    void GivenPaginatedRequest_WhenUsingPaginateConstructor_ThenReturnDefaults() {
        //Given
        var pageNumberMock = -1;
        var pageSizeMock = 50;

        //When
        var result = new PaginatedRequest(
                pageNumberMock,
                pageSizeMock
        );

        //Then
        Assert.assertTrue(result.getPageNumber() == 1);
        Assert.assertTrue(result.getPageSize() == 20);
        Assert.assertTrue(result.getOrderingValue().equals("Id"));
        Assert.assertTrue(result.getOrderDirection().equals("asc"));
        Assert.assertTrue(result.getPhrase() == null);
    }

    @Test
    void GivenPaginatedRequest_WhenUsingPaginateAndOrderingConstructor_ThenReturnDefaults() {
        //Given
        var pageNumberMock = -1;
        var pageSizeMock = 50;
        var orderValueMock = "test";
        var orderDirectionMock = "test";

        //When
        var result = new PaginatedRequest(
                pageNumberMock,
                pageSizeMock,
                orderValueMock,
                orderDirectionMock
        );

        //Then
        Assert.assertTrue(result.getPageNumber() == 1);
        Assert.assertTrue(result.getPageSize() == 20);
        Assert.assertTrue(result.getOrderingValue().equals("Test"));
        Assert.assertTrue(result.getOrderDirection().equals("asc"));
        Assert.assertTrue(result.getPhrase() == null);
    }

    @Test
    void GivenPaginatedRequest_WhenUsingPaginateAndOrderingAndSearchConstructor_ThenReturnDefaults() {
        //Given
        var pageNumberMock = -1;
        var pageSizeMock = 50;
        var orderValueMock = "test";
        var orderDirectionMock = "test";
        var phraseMock = "test";

        //When
        var result = new PaginatedRequest(
                pageNumberMock,
                pageSizeMock,
                orderValueMock,
                orderDirectionMock,
                phraseMock
        );

        //Then
        Assert.assertTrue(result.getPageNumber() == 1);
        Assert.assertTrue(result.getPageSize() == 20);
        Assert.assertTrue(result.getOrderingValue().equals("Test"));
        Assert.assertTrue(result.getOrderDirection().equals("asc"));
        Assert.assertTrue(result.getPhrase().equals(phraseMock));
    }
}