package de.hsos.swa.drink.boundary;

import de.hsos.swa.drink.acl.CocktailsListDTO;
import de.hsos.swa.drink.acl.DrinkRecipeDTO;
import de.hsos.swa.drink.acl.DrinkRecipeCocktailDTO;
import de.hsos.swa.drink.al.ReadDrinkRecipe;

import de.hsos.swa.drink.bl.cocktails.gateway.MPCocktailsRestClient;
import de.hsos.swa.shared.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.openapi.annotations.Operation;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.rest.client.inject.RestClient;


import java.util.List;

@Path("/drinks/cocktails")
@Log(Log.Level.INFO)
public class CocktailRessource {

    @Inject
    ReadDrinkRecipe readService;

    @Inject
    //JEECocktailsRestClient cocktailsRestClient;
    @RestClient
    MPCocktailsRestClient cocktailsRestClient;

    @GET
    @Operation(summary = "Get cocktails", description = "Get a List of all cocktails")
    @APIResponses(
            value = {
                    @APIResponse(responseCode = "200", description = "Successfully get all Cocktails",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DrinkRecipeDTO.class))),
            }
    )
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(maxRetries = 4)
    @Timeout(10000)
//    @Fallback(fallbackMethod = "getMocktailsAsFallback")
    public Response readAllCocktails() {

        //List<DrinkRecipeDTO> list = this.readService.readAllCocktailRecipes();
        CocktailsListDTO list = this.cocktailsRestClient.getAllCocktails("Cocktail");
        return Response.ok(list).build();
    }

    @GET
    @Operation(summary = "Get cocktails by Name", description = "Get a List of all cocktails with a certain name")
    @APIResponses(
            value = {
                    @APIResponse(responseCode = "200", description = "Successfully get all Cocktails with the certain name",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DrinkRecipeDTO.class))),
            }
    )
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/name={name}")
    public Response readCocktailsByName(@PathParam("name") String name) {
        CocktailsListDTO list = cocktailsRestClient.getCocktailsByName(name);

        return Response.ok(list).build();
    }

    /* Laut Aufgabenstellung eigentlich nicht gebraucht
    @GET
    @Operation(summary = "Get cocktail by id", description = "Get a  cocktail with a certain id")
    @APIResponses(
            value = {
                    @APIResponse(responseCode = "200", description = "Successfully get the cocktail with the certain id",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DrinkRecipeDTO.class))),
            }
    )
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id={cocktailId}")
    public Response readCocktailById(@PathParam("cocktailId") int id) {
        DrinkRecipeCocktailDTO cocktail = cocktailsRestClient.getCocktailById(id);
        return Response.ok(cocktail).build();
    }
    */

    @GET
    @Operation(summary = "Get cocktails with ingredient", description = "Get a List of all cocktails containing the specified ingredient")
    @APIResponses(
            value = {
                    @APIResponse(responseCode = "200", description = "Successfully get all Cocktails containing the ingredient",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DrinkRecipeDTO.class))),
            }
    )
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ingredient={ingredient}")
    public Response readIngredient(@PathParam("ingredient") String ingredient) {
        CocktailsListDTO list = cocktailsRestClient.getCocktailsByIngredient(ingredient);
        return Response.ok(list).build();
    }

    //TODO:Braucht Fallback-Methode hier Auch Annotationen
    public Response getMocktailsAsFallback() {
        List<DrinkRecipeDTO> list = this.readService.readAllMocktailRecipes();
        return Response.ok(list).build();
    }
}
