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

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;



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
    @Operation(summary = "Create drink", description = "Create a drink, the application will decide wether it's a cocktail or mocktail")
    @APIResponses(
            value = {
                    @APIResponse(responseCode = "201", description = "Drink successfully created",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DrinkRecipeDTO.class)))
            }
    )
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(maxRetries = 4)
    public Response createDrinkRecipe(DrinkRecipeDTO drinkRecipeDTO) {
        drinkRecipeDTO = createService.createDrinkRecipe(drinkRecipeDTO);
        return Response.status(Response.Status.CREATED).entity(drinkRecipeDTO).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get drink", description = "get a drink by id")
    @APIResponses(
            value = {
                    @APIResponse(responseCode = "200", description = "Successfully get the drink specified by id",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DrinkRecipeDTO.class))),
                    @APIResponse(responseCode = "404", description = "given id not associated with any drink",
                            content = @Content(mediaType = MediaType.TEXT_PLAIN))
            }
    )
    @Produces(MediaType.APPLICATION_JSON)
   // @Fallback(fallbackMethod = "readAllDrinkRecipes")
    @Retry(maxRetries = 4)
    public Response readDrinkRecipe(@PathParam("id") int id) {
        DrinkRecipeDTO drinkRecipe = readService.readDrinkRecipe(id);


        if (drinkRecipe == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(drinkRecipe).build();
    }


    @GET
    @Operation(summary = "Get all drinks", description = "Get all drinks, i.e. all mocktails and cocktails in one list")
    @APIResponses(
            value = {
                    @APIResponse(responseCode = "200", description = "Successfully get all drinks",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DrinkRecipeDTO.class))),
            }
    )
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(maxRetries = 4)
    public Response readAllDrinkRecipes() {
        List<DrinkRecipeDTO> list = this.readService.readAllDrinkRecipes();

        return Response.ok(list).build();
    }

    @PUT
    @Operation(summary = "update drinks", description = "update a drink specified by id")
    @APIResponses(
            value = {
                    @APIResponse(responseCode = "200", description = "Successfully updated drink",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DrinkRecipeDTO.class))),
            }
    )
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(maxRetries = 4)
    public Response updateDrinkRecipe(@PathParam("id") int id, DrinkRecipeDTO drinkRecipeDTO) {
        updateService.updateDrinkRecipe(id, drinkRecipeDTO.getName(), drinkRecipeDTO.getIngredients(), drinkRecipeDTO.getPreparation());
        return Response.ok().entity(readService.readDrinkRecipe(id)).build();
    }

    @DELETE
    @Operation(summary = "delete drink", description = "Delete drink specified by id")
    @APIResponses(
            value = {
                    @APIResponse(responseCode = "204", description = "Successfully deleted drink",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DrinkRecipeDTO.class))),
                    @APIResponse(responseCode = "404", description = "id not associated with any drink",
                            content = @Content(mediaType = MediaType.TEXT_PLAIN))
            }
    )
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(maxRetries = 4)
    public Response deleteDrinkRecipe(@PathParam("id") int id) {
        if (!deleteService.deleteDrinkRecipe(id)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}