package Application.BuildingBlocks.Primitives;

import java.util.List;

public class PaginatedResponse<T> {
    public List<T> ListOfItems;

    public Integer TotalItemsCount;

    public PaginatedResponse() {
    }

    public PaginatedResponse(List<T> listOfItems, Integer totalItemsCount) {
        ListOfItems = listOfItems;
        TotalItemsCount = totalItemsCount;
    }

    private List<T> getListOfItems() {
        return ListOfItems;
    }

    private void setListOfItems(List<T> listOfItems) {
        ListOfItems = listOfItems;
    }

    private Integer getItemsCount() {
        return TotalItemsCount;
    }

    private void setItemsCount(Integer itemsCount) {
        TotalItemsCount = itemsCount;
    }
}
