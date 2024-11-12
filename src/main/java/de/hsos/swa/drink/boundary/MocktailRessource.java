package de.hsos.swa.drink.boundary;

import de.hsos.swa.drink.acl.DrinkRecipeDTO;
import de.hsos.swa.drink.al.ReadDrinkRecipe;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/drinks/mocktails")
public class MocktailRessource {
    private static final Logger logging = Logger.getLogger(MocktailRessource.class);

    @Inject
    ReadDrinkRecipe readService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAllMocktails() {
        logging.info("Getting all mocktail recipes");
        List<DrinkRecipeDTO> list = this.readService.readAllMocktailRecipes();
        logging.trace("All mocktail recipes: " + list);
        return Response.ok(list).build();
    }
}
