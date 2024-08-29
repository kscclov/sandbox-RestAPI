package RestOperations.product;

public enum ProductType {
    FRUIT("Фрукт"),VEGETABLE("Овощ");

    private String type;

    ProductType(String type) {
        this.type = type;
    }

    public String getValue() {
        return type;
    }
}