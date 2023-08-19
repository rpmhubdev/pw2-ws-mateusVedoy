package dev.rpmhub;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class StartTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/api/hello")
                .then()
                .statusCode(200)
                .body(is("Hello from RESTEasy"));
    }

    /**
     * Test kmh2mih endpoint: O endpoint deve consumir dados por POST e produzir
     * dados em texto e converter quilômetro por hora para milhas por hora
     * (1=0.621)
     */
    @Test
    public void testKmh2mih() {
        given()
            .contentType("application/x-www-form-urlencoded; charset=utf-8")
            .formParam("kmh", "1")
        .when()
            .post("/api/kmh2mih")
        .then()
            .statusCode(200)
            .body(is("0.621"));
    }

     /**
     * Test No2kmh endpoint: O endpoint deve consumir dados por GET e produzir
     * dados em em JSON e converter Nós para quilometro por hora (1=1.852)
     */
    @Test
    public void testNo2kmh() {
        given()
        .when()
            .get("/api/no2kmh/1")
        .then()
            .statusCode(200)
            .body(is("1.852"));
    }

}