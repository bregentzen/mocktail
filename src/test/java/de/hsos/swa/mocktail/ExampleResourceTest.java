package de.hsos.swa.mocktail;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ExampleResourceTest {
    @Test
    void testReadAllRecipes() {
    }

    @Test
    void testReadRecipe() {
        String id = "0";
        given()
                .param("id", id)
                .when().get()//TODO: get(<url>)
                .then()
                .statusCode(200)
                .body("id", is(id)); //TODO: Edit
    }

    @Test
    void testCreateRecipe() {

    }

    @Test
    void testUpdateRecipe() {

    }

    @Test
    void testDeleteRecipe() {

    }

}