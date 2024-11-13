package de.hsos.swa.drink.boundary;

import de.hsos.swa.drink.acl.DrinkRecipeDTO;
import de.hsos.swa.drink.al.ReadDrinkRecipe;
import de.hsos.swa.shared.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;


import java.util.List;

@Path("/drinks/mocktails")
@Log(Log.Level.INFO)
public class MocktailRessource {

    @Inject
    ReadDrinkRecipe readService;

    @GET
    @Operation(summary = "Get mocktails", description = "Get all mocktails")
    @APIResponses(
            value = {
                    @APIResponse(responseCode = "200", description = "Successfully get all Mocktails",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DrinkRecipeDTO.class))),
            }
    )
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAllMocktails() {
        List<DrinkRecipeDTO> list = this.readService.readAllMocktailRecipes();
         return Response.ok(list).build();
    }
}
