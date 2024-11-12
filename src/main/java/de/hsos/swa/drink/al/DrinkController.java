package de.hsos.swa.drink.al;

import de.hsos.swa.drink.acl.DrinkRecipeConverter;
import de.hsos.swa.drink.acl.DrinkRecipeDTO;
import de.hsos.swa.drink.bl.DrinkService;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Dependent
public class DrinkController implements CreateDrinkRecipe, ReadDrinkRecipe, UpdateDrinkRecipe, DeleteDrinkRecipe {
    private static final Logger logging = Logger.getLogger(DrinkController.class);

    @Inject
    DrinkService drinkService;

    @Override
    public DrinkRecipeDTO createDrinkRecipe(DrinkRecipeDTO drinkRecipeDTO) {

        logging.info("Creating new drink recipe");
        logging.trace("Name: " + drinkRecipeDTO.getName() + ", Ingredients: " + drinkRecipeDTO.getIngredients() + ", Preparation: " + drinkRecipeDTO.getPreparation());

        return DrinkRecipeConverter.convertToDTO(drinkService.createDrinkRecipe(
                drinkRecipeDTO.getName(),
                drinkRecipeDTO.getIngredients(),
                drinkRecipeDTO.getPreparation()
        ));
    }

    @Override
    public boolean deleteDrinkRecipe(int id) {
        logging.info("Deleting drink recipe with id " + id);
        logging.trace("ID: " + id + ", Recipe: " + drinkService.getDrinkRecipe(id));
        return drinkService.deleteDrinkRecipe(id);
    }

    @Override
    public DrinkRecipeDTO readDrinkRecipe(int id) {
        logging.info("Getting drink recipe with id " + id);
        logging.trace("ID: " + id + ", Recipe: " + drinkService.getDrinkRecipe(id));
        return DrinkRecipeConverter.convertToDTO(drinkService.getDrinkRecipe(id));
    }

    @Override
    public List<DrinkRecipeDTO> readAllDrinkRecipes() {
        logging.info("Getting all drink recipes");
        logging.trace("All drink recipes: " + drinkService.getAllDrinkRecipes());
        return drinkService.getAllDrinkRecipes().values().stream().map(DrinkRecipeConverter::convertToDTO).toList();
    }

    @Override
    public List<DrinkRecipeDTO> readAllCocktailRecipes() {
        logging.info("Getting all cocktail recipes");
        logging.trace("All cocktail recipes: " + drinkService.getAllCocktailRecipes());
        return drinkService.getAllCocktailRecipes().stream().map(DrinkRecipeConverter::convertToDTO).toList();
    }

    @Override
    public List<DrinkRecipeDTO> readAllMocktailRecipes() {
        logging.info("Getting all mocktail recipes");
        logging.trace("All mocktail recipes: " + drinkService.getAllMocktailRecipes());
        return drinkService.getAllMocktailRecipes().stream().map(DrinkRecipeConverter::convertToDTO).toList();
    }

    @Override
    public void updateDrinkRecipe(int id, String name, List<String> ingredients, String instructions) {
        logging.info("Updating drink recipe with id " + id);
        logging.trace("ID: " + id + ", Name: " + name + ", Ingredients: " + ingredients + ", Instructions: " + instructions);
        drinkService.editDrinkRecipe(id,
                name, ingredients, instructions);
    }
}
