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
import org.jboss.logging.Logger;

import java.util.List;

@Path("/drinks/mocktails")
@Log(Log.Level.INFO)
public class MocktailRessource {

    @Inject
    ReadDrinkRecipe readService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAllMocktails() {
        List<DrinkRecipeDTO> list = this.readService.readAllMocktailRecipes();
         return Response.ok(list).build();
    }
}
