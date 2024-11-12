package de.hsos.swa.drink.boundary;

import de.hsos.swa.drink.acl.DrinkRecipeDTO;
import de.hsos.swa.drink.al.CreateDrinkRecipe;
import de.hsos.swa.drink.al.ReadDrinkRecipe;
import de.hsos.swa.drink.al.UpdateDrinkRecipe;
import de.hsos.swa.drink.al.DeleteDrinkRecipe;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.jboss.logging.Logger;


@Path("/drinks")
public class DrinkRessource {

    private static final Logger logging = Logger.getLogger(DrinkRessource.class);
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
        logging.info("Creating new drink recipe");
        logging.trace("Name: " + drinkRecipeDTO.getName() + ", Ingredients: " + drinkRecipeDTO.getIngredients() + ", Preparation: " + drinkRecipeDTO.getPreparation());
        drinkRecipeDTO = createService.createDrinkRecipe(drinkRecipeDTO);
        return Response.status(Response.Status.CREATED).entity(drinkRecipeDTO).build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readDrinkRecipe(@PathParam("id") int id) {
        logging.info("Getting drink recipe with id " + id);
        DrinkRecipeDTO drinkRecipe = readService.readDrinkRecipe(id);


        if (drinkRecipe == null) {
            logging.warn("Drink recipe with id " + id + " not found");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        logging.trace("ID: " + id + ", Recipe: " + drinkRecipe);
        return Response.ok().entity(drinkRecipe).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAllMDrinkRecipes() {
        logging.info("Getting all drink recipes");
        List<DrinkRecipeDTO> list = this.readService.readAllDrinkRecipes();
        logging.trace("All drink recipes: " + list);
        return Response.ok(list).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDrinkRecipe(@PathParam("id") int id, DrinkRecipeDTO drinkRecipeDTO) {
        logging.info("Updating drink recipe with id " + id);
        updateService.updateDrinkRecipe(id, drinkRecipeDTO.getName(), drinkRecipeDTO.getIngredients(), drinkRecipeDTO.getPreparation());
        logging.trace("Updated drink recipe: " + readService.readDrinkRecipe(id));
        return Response.ok().entity(readService.readDrinkRecipe(id)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDrinkRecipe(@PathParam("id") int id) {
        logging.info("Deleting drink recipe with id " + id);
        if (!deleteService.deleteDrinkRecipe(id)) {
            logging.warn("Drink recipe with id " + id + " not found");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        logging.trace("Deleted drink recipe with id " + id);
        return Response.noContent().build();
    }
}