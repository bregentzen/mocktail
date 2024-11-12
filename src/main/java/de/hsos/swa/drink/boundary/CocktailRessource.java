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

@Path("/drinks/cocktails")
public class CocktailRessource {
    private static final Logger logging = Logger.getLogger(CocktailRessource.class);

    @Inject
    ReadDrinkRecipe readService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAllCocktails() {
        logging.info("Getting all cocktail recipes");
        List<DrinkRecipeDTO> list = this.readService.readAllCocktailRecipes();
        logging.trace("All cocktail recipes: " + list);
        return Response.ok(list).build();
    }
}
