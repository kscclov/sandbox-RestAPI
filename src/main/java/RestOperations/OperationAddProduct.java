package RestOperations;

import RestOperations.BaseRestOperation.BaseRestOperation;
import RestOperations.product.ProductData;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class OperationAddProduct extends BaseRestOperation {

    private int entriesCount;

    @Step
    public OperationAddProduct setCurrentEntriesCount() {
        entriesCount = getAllProductData().size();
        return this;
    }

    @Step
    public OperationAddProduct executeAddProductRequest(ProductData productData) {
        given()
                .contentType(ContentType.JSON)
                .body(productData)
                .when()
                .post("api/food")
                .then()
                .statusCode(200);
        return this;
    }

    @Step
    public OperationAddProduct checkEntriesCountAfterAddProduct() {
        int expectedCount = ++entriesCount;
        int actualCount = getAllProductData().size();
        Assertions.assertEquals(expectedCount, actualCount);
        return this;
    }

    @Step
    public OperationAddProduct checkAddedProductPresence(ProductData productData) {
        List<ProductData> productList = getAllProductData();
        Assertions.assertTrue(productList.contains(productData));
        return this;
    }

    private List<ProductData> getAllProductData() {
        return Arrays.asList(given()
                .when()
                .get("api/food")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .body()
                .as(ProductData[].class));
    }

}
