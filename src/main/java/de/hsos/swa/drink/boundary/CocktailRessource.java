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
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.extensions.Extension;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/drinks/cocktails")
@Log(Log.Level.INFO)
public class CocktailRessource {

    @Inject
    ReadDrinkRecipe readService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAllCocktails() {

        List<DrinkRecipeDTO> list = this.readService.readAllCocktailRecipes();
        return Response.ok(list).build();
    }
}
