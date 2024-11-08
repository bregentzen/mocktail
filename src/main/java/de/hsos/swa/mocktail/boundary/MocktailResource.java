package de.hsos.swa.mocktail.boundary;

import de.hsos.swa.mocktail.acl.MocktailRecipeDTO;
import de.hsos.swa.mocktail.al.CreateMocktailRecipe;
import de.hsos.swa.mocktail.al.ReadMocktailRecipe;
import de.hsos.swa.mocktail.al.UpdateMocktailRecipe;
import de.hsos.swa.mocktail.al.DeleteMocktailRecipe;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMocktailRecipe(MocktailRecipeDTO mocktailRecipeDTO) {
        int result = createService.createMocktailRecipe(mocktailRecipeDTO.getName(), String.join(",", mocktailRecipeDTO.getIngredients()), mocktailRecipeDTO.getPreparation());
        return Response.status(Response.Status.CREATED).entity(result).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readMocktailRecipe(@PathParam("id") String id) {
        readService.readMocktailRecipe(id);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAllMocktailRecipes() {
        readService.readAllMocktailRecipes();
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateMocktailRecipe(@PathParam("id") String id, MocktailRecipeDTO mocktailRecipeDTO) {
        updateService.updateMocktailRecipe(id, mocktailRecipeDTO.getName(), String.join(",", mocktailRecipeDTO.getIngredients()), mocktailRecipeDTO.getPreparation());
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteMocktailRecipe(@PathParam("id") String id) {
        deleteService.deleteMocktailRecipe(id);
        return Response.noContent().build();
    }
}
