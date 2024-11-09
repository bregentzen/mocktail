package de.hsos.swa.mocktail.boundary;

import de.hsos.swa.mocktail.acl.MocktailRecipeDTO;
import de.hsos.swa.mocktail.al.CreateMocktailRecipe;
import de.hsos.swa.mocktail.al.ReadMocktailRecipe;
import de.hsos.swa.mocktail.al.UpdateMocktailRecipe;
import de.hsos.swa.mocktail.al.DeleteMocktailRecipe;
import de.hsos.swa.mocktail.bl.MocktailRecipe;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("/mocktails")
public class MocktailResource {

    @Inject
    CreateMocktailRecipe createService;
    @Inject
    ReadMocktailRecipe readService;
    @Inject
    UpdateMocktailRecipe updateService;
    @Inject
    DeleteMocktailRecipe deleteService;
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

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readMocktailRecipe(@PathParam("id") int id) {
        MocktailRecipe mocktailRecipe = readService.readMocktailRecipe(id);
        MocktailRecipeDTO mocktailRecipeDTO = MocktailRecipeKonverter.convertToDTO(mocktailRecipe);
        return Response.ok().entity(mocktailRecipeDTO).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAllMocktailRecipes() {
        List<MocktailRecipeDTO> list = this.readService.readAllMocktailRecipes().values().stream().map(MocktailRecipeKonverter::convertToDTO).toList();
        return Response.ok(list).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateMocktailRecipe(@PathParam("id") int id, MocktailRecipeDTO mocktailRecipeDTO) {

        updateService.updateMocktailRecipe(id, mocktailRecipeDTO.getName(), mocktailRecipeDTO.getIngredients(), mocktailRecipeDTO.getPreparation());
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteMocktailRecipe(@PathParam("id") int id) {
        deleteService.deleteMocktailRecipe(id);
        return Response.noContent().build();
    }
}