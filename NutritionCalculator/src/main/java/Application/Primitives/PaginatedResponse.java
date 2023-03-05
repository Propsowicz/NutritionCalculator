package Application.Primitives;

import java.util.List;

public class PaginatedResponse<T> {
    public List<T> ListOfItems;

    public Integer ItemsCount;

    public PaginatedResponse() {
    }

    public PaginatedResponse(List<T> listOfItems, Integer itemsCount) {
        ListOfItems = listOfItems;
        ItemsCount = itemsCount;
    }

    public List<T> getListOfItems() {
        return ListOfItems;
    }

    public void setListOfItems(List<T> listOfItems) {
        ListOfItems = listOfItems;
    }

    public Integer getItemsCount() {
        return ItemsCount;
    }

    public void setItemsCount(Integer itemsCount) {
        ItemsCount = itemsCount;
    }
}
