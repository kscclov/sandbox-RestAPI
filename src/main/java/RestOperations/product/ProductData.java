package RestOperations.product;

import java.util.Objects;

public class ProductData {
    private String name;
    private String type;
    private boolean exotic;

    public ProductData(Product product) {
        this.name = product.getName();
        this.type = product.getType().name();
        this.exotic = product.isExotic();
    }

    public ProductData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isExotic() {
        return exotic;
    }

    public void setExotic(boolean exotic) {
        this.exotic = exotic;
    }

    @Override
    public String toString() {
        return "ProductData{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", exotic=" + exotic +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductData productData = (ProductData) o;
        return exotic == productData.exotic && Objects.equals(name, productData.name) && Objects.equals(type, productData.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, exotic);
    }
}
