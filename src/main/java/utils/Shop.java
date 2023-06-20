package utils;

public class Shop {
    private final String item;
    private final Object countOfProduct;
    private final int priceOfProduct;

    public Shop(String item, int countOfProduct, int priceOfProduct) {
        this.item=item;
        this.countOfProduct = countOfProduct;
        this.priceOfProduct = priceOfProduct;
    }
}
