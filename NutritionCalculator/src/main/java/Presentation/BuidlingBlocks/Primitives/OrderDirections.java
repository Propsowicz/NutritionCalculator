package Presentation.BuidlingBlocks.Primitives;

public class OrderDirections {
    private static final String ASC = "asc";

    private static final String DESC = "desc";

    public static String Handle (String orderDirectory){
        if (orderDirectory == null) { return OrderDirections.ASC; }
        if (orderDirectory.equals(OrderDirections.ASC)) { return OrderDirections.ASC; };
        if (orderDirectory.equals(OrderDirections.DESC)) { return OrderDirections.DESC; };
        return OrderDirections.ASC;
    }
}
