package de.hsos.swa.drink.boundary;

import de.hsos.swa.drink.acl.DrinkRecipeDTO;
import de.hsos.swa.drink.al.CreateDrinkRecipe;
import de.hsos.swa.drink.al.ReadDrinkRecipe;
import de.hsos.swa.drink.al.UpdateDrinkRecipe;
import de.hsos.swa.drink.al.DeleteDrinkRecipe;
import de.hsos.swa.shared.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.jboss.logging.Logger;


@Path("/drinks")
@Log(Log.Level.INFO)
public class DrinkRessource {

    @Inject
    CreateDrinkRecipe createService;
    @Inject
    ReadDrinkRecipe readService;
    @Inject
    UpdateDrinkRecipe updateService;
    @Inject
    DeleteDrinkRecipe deleteService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDrinkRecipe(DrinkRecipeDTO drinkRecipeDTO) {
        drinkRecipeDTO = createService.createDrinkRecipe(drinkRecipeDTO);
        return Response.status(Response.Status.CREATED).entity(drinkRecipeDTO).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readDrinkRecipe(@PathParam("id") int id) {
        DrinkRecipeDTO drinkRecipe = readService.readDrinkRecipe(id);


        if (drinkRecipe == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(drinkRecipe).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAllMDrinkRecipes() {
        List<DrinkRecipeDTO> list = this.readService.readAllDrinkRecipes();
        return Response.ok(list).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDrinkRecipe(@PathParam("id") int id, DrinkRecipeDTO drinkRecipeDTO) {
         updateService.updateDrinkRecipe(id, drinkRecipeDTO.getName(), drinkRecipeDTO.getIngredients(), drinkRecipeDTO.getPreparation());
        return Response.ok().entity(readService.readDrinkRecipe(id)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDrinkRecipe(@PathParam("id") int id) {
         if (!deleteService.deleteDrinkRecipe(id)) {
              return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}