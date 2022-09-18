package tests;

import models.SupportData;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Specs.request;
import static specs.Specs.response;

public class LombokTest {
    @Test
    void checkSupportEmail() {
        SupportData supportData = (SupportData) given()
                .spec(request)
                .when()
                .get("/users/2")
                .then()
                .spec(response)
                .log().body()
                .extract().as(SupportData.class);
        assertEquals("https://reqres.in/#support-heading", supportData.getSupport().getURL());
    }
}
