package de.hsos.swa.drink.bl;

import de.hsos.swa.drink.cdi.IdProducer;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

/**
 * Only class that is allowed to create new DrinkRecipe Objects
 */

@Dependent
public class DrinkService {
    private static final Logger logging = Logger.getLogger(DrinkService.class);

    @Inject
    DrinkMenu drinkMenu;

    @Inject
    IngredientCatalog ingredientCatalog;

    @Inject
    isAlcoholicService isAlcoholicService;

    @Inject
    IdProducer idProducer;

    public DrinkRecipe getDrinkRecipe(int id) {
        logging.info("Getting mocktail recipe with id " + id);
        logging.trace("ID: " + id + ", Recipe: " + drinkMenu.getDrinkRecipe(id));
        return drinkMenu.getDrinkRecipe(id);
    }

    public Map<Integer, DrinkRecipe> getAllDrinkRecipes() {
        logging.info("Getting all drink recipes");
        logging.trace("All drink recipes: " + drinkMenu.getAllDrinkRecipes());
        return drinkMenu.getAllDrinkRecipes();
    }

    public DrinkRecipe createDrinkRecipe(String name, List<String> ingredients, String preparation) {
        logging.info("Creating drink recipe");
        logging.trace("Name: " + name + ", Ingredients: " + ingredients + ", Preparation: " + preparation);
        List<Ingredient> ingredientsList = new ArrayList<>();
        for(String ingredientName : ingredients) {
            if(ingredientCatalog.getIngredient(ingredientName) == null) {
                throw new IllegalArgumentException("Ingredient " + ingredientName + " does not exist");
            }
            else {
                ingredientsList.add(new Ingredient(ingredientCatalog.getIngredient(ingredientName).getName(), ingredientCatalog.getIngredient(ingredientName).getIsAlcoholic()));
            }
        }
        int id = idProducer.createId();
        DrinkRecipe drinkRecipe = new DrinkRecipe(name, preparation, ingredientsList, id);
        logging.trace("Drink recipe: " + drinkRecipe);
        return drinkMenu.saveDrinkRecipe(drinkRecipe);
    }
    public boolean deleteDrinkRecipe(int id) {
        logging.info("Deleting mocktail recipe");
        return drinkMenu.deleteDrinkRecipe(id);
    }

    public void editDrinkRecipe(int id, String name, List<String> ingredients, String preparation) {
        logging.info("Editing drink recipe");
        List<Ingredient> ingredientsList = ingredients.stream().map(ingredientName -> ingredientCatalog.getIngredient(ingredientName)).toList();
        logging.trace("ID: " + id + ", Name: " + name + ", Ingredients: " + ingredients + ", Preparation: " + preparation);
        drinkMenu.updateDrinkRecipe(id, name, ingredientsList, preparation);
    }

    public List<DrinkRecipe> getAllCocktailRecipes() {
        logging.info("Getting all cocktail recipes");
        logging.trace("All cocktail recipes: " + drinkMenu.getAllDrinkRecipes().values().stream().filter(isAlcoholicService::isAlcoholic).toList());
        return drinkMenu.getAllDrinkRecipes().values().stream().filter(isAlcoholicService::isAlcoholic).toList();

    }

    public List<DrinkRecipe> getAllMocktailRecipes() {
        logging.info("Getting all mocktail recipes");
        logging.trace("All mocktail recipes: " + drinkMenu.getAllDrinkRecipes().values().stream().filter(drinkRecipe -> !isAlcoholicService.isAlcoholic(drinkRecipe)).toList());
        return drinkMenu.getAllDrinkRecipes().values().stream().filter(drinkRecipe -> !isAlcoholicService.isAlcoholic(drinkRecipe)).toList();
    }
}
