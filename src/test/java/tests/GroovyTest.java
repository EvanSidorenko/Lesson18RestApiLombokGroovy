package tests;

import org.junit.jupiter.api.Test;
import specs.Specs;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class GroovyTest {
    @Test
    void checkEmailGroovy() {
        given()
                .spec(Specs.request)
                .get("/users?page=2")
                .then()
                .spec(Specs.response)
                .body("data.findAll{it.email =~/.*?@reqres.in/}.email.flatten()",
                        hasItem("byron.fields@reqres.in"))
                .body("data.findAll{it.first_name}.first_name.flatten()", hasItem("Byron"));
    }
}
