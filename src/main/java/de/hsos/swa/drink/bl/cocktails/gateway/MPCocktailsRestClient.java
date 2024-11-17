package de.hsos.swa.drink.bl.cocktails.gateway;

import de.hsos.swa.drink.acl.CocktailsListDTO;
import de.hsos.swa.drink.acl.DrinkRecipeCocktailDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(configKey = "cocktails")
public interface MPCocktailsRestClient {

    @GET
    @Path("/filter.php")
    CocktailsListDTO getAllCocktails(@QueryParam("c") String category);

    @GET
    @Path("/search.php")
    CocktailsListDTO getCocktailsByName(@QueryParam("s") String cocktailName);

    @GET
    @Path("/lookup.php")
    CocktailsListDTO getCocktailById(@QueryParam("i") int id);

    @GET
    @Path("/filter.php")
    CocktailsListDTO getCocktailsByIngredient(@QueryParam("i") String ingredientName);

}
