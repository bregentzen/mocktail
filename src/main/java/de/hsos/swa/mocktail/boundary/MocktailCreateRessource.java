package de.hsos.swa.mocktail.boundary;

import de.hsos.swa.mocktail.acl.MocktailRecipeDTO;
import de.hsos.swa.mocktail.al.CreateMocktailRecipe;
import de.hsos.swa.mocktail.bl.MocktailRecipe;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("/mocktails")
public class MocktailCreateRessource {
    @Inject
    CreateMocktailRecipe createService;
    @Inject
    int id;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMocktailRecipe(MocktailRecipeDTO mocktailRecipeDTO) {
        //System.out.println("Creating mocktail recipe" + id);
        MocktailRecipe mocktailRecipe = createService.createMocktailRecipe(id, mocktailRecipeDTO.getName(), mocktailRecipeDTO.getIngredients(), mocktailRecipeDTO.getPreparation());
        MocktailRecipeDTO mocktailRecipeDTO1 = MocktailRecipeKonverter.convertToDTO(mocktailRecipe);
        return Response.status(Response.Status.CREATED).entity(mocktailRecipeDTO1).build();
    }
}
