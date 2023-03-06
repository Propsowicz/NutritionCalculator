package Presentation.BuidlingBlocks.Primitives;

import org.apache.commons.lang3.StringUtils;

public class PaginatedRequest {
    private final Integer MAX_PAGE_SIZE = 20;

    private Integer PageNumber;

    private Integer PageSize;

    private String OrderingValue;

    private String OrderDirection;

    private String Phrase;

    public PaginatedRequest() {
    }

    public PaginatedRequest(Integer pageNumber, Integer pageSize) {
        PageNumber = pageNumber;
        PageSize = pageSize;
    }

    public PaginatedRequest(Integer pageNumber, Integer pageSize, String orderingValue, String orderDirection) {
        PageNumber = pageNumber;
        PageSize = pageSize;
        OrderingValue = orderingValue;
        OrderDirection = orderDirection;
    }

    public PaginatedRequest(Integer pageNumber, Integer pageSize, String orderingValue, String orderDirection, String phrase) {
        PageNumber = pageNumber;
        PageSize = pageSize;
        OrderingValue = orderingValue;
        OrderDirection = orderDirection;
        Phrase = phrase;
    }

    public Integer getPageNumber() {
        if (PageNumber == null || PageNumber < 1) { return 1; }
        return PageNumber;
    }

    public Integer getPageSize() {
        if (PageSize == null || PageSize < 1 || PageSize > MAX_PAGE_SIZE) { return MAX_PAGE_SIZE; };
        return PageSize;
    }

    public String getOrderingValue() {
        if (OrderingValue == null) { return "Id"; };
        return StringUtils.capitalize(OrderingValue);
    }

    public String getOrderDirection() {
        return OrderDirections.Handle(OrderDirection);
    }

    public String getPhrase() {
        return Phrase;
    }
}
