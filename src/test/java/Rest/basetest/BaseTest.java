package Rest.basetest;

import RestOperations.RestManager;
import RestOperations.BaseRestOperation.BaseRestOperation;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

public class BaseTest {
    protected static final RestManager restManager = RestManager.getRestManager();

    private static Cookies getCookies() {
        return RestAssured.given()
                .when()
                .get("api/food")
                .getDetailedCookies();
    }
    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080/")
                .addCookies(getCookies())
                .build();
    }


    @BeforeAll
    public static void setRequestSpec() {
        RestAssured.requestSpecification = getRequestSpec();
    }

    @AfterAll
    public static void resetDataAfter() {
        BaseRestOperation.resetData();
    }
}