package rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class PostmanApiTest {
    @Test
    void shouldReturnDemoAccounts() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")
                .when()
                .post("/post")
                .then()
                .statusCode(200).log().all()
                .body(matchesJsonSchemaInClasspath("postman.schema.json"))
        ;g
    }
}
