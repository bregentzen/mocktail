package de.hsos.swa.drink;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
class ExampleResourceTest {

    @Test
    public void testCreateMocktailRecipe() {
        String requestBody = """
                {
                  "name": "Tropical Delight",
                  "preparation": "Mix all ingredients and serve over ice.",
                  "ingredients": ["pineappleJuice", "orangeJuice", "mint", "ice"]
                }
                """;


        given()
                .contentType("application/json")
                .body(requestBody)
                .when().post("/mocktails")
                .then()
                .statusCode(201)
                .body("name", is("Tropical Delight"))
                .body("preparation", is("Mix all ingredients and serve over ice."))
                .body("id", notNullValue());
    }

    @Test
    public void testReadMocktailRecipe() {
        testCreateMocktailRecipe();
        int mocktailId = 1;


        given()
                .pathParam("id", mocktailId)
                .when().get("/mocktails/{id}")
                .then().assertThat()
                .statusCode(200)
                .body("id", is(mocktailId))
                .body("name", notNullValue())
                .body("preparation", notNullValue())
                .body("ingredients", notNullValue());
    }


    @Test
    public void testBadReadMocktailRecipe() {
        int mocktailId = 2;

        given()
                .pathParam("id", mocktailId)
                .when().get("/mocktails/{id}")
                .then().assertThat()
                .statusCode(404);
    }

    @Test
    public void testReadAllMocktailRecipes() {

        given()
                .when().get("/mocktails")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    public void testUpdateMocktailRecipe() {
        int mocktailId = 1;
        String updateRequestBody = """
                {
                  "name": "Updated Tropical Delight",
                  "preparation": "Stir well and serve over ice.",
                  "ingredients": ["water", "appleJuice"]
                }
                """;


        given()
                .contentType("application/json")
                .pathParam("id", mocktailId)
                .body(updateRequestBody)
                .when().put("/mocktails/{id}")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("name", is("Updated Tropical Delight"))
                .body("preparation", is("Stir well and serve over ice."))
                .body("ingredients.size()", is(2));
    }

    @Test
    public void testDeleteMocktailRecipe() {
        int mocktailId = 1;

        given()
                .pathParam("id", mocktailId)
                .when().delete("/mocktails/{id}")
                .then()
                .statusCode(204);


        given()
                .pathParam("id", mocktailId)
                .when().get("/mocktails/{id}")
                .then()
                .statusCode(404);
    }
}
