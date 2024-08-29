package RestOperations.BaseRestOperation;

import static io.restassured.RestAssured.given;

public class BaseRestOperation {

    public static void resetData() {
        given()
                .when()
                .post("api/data/reset")
                .then()
                .statusCode(200);
    }

}
