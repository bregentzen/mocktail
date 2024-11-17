package de.hsos.swa.drink.bl;

import de.hsos.swa.drink.cdi.IdProducer;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

/**
 * Only class that is allowed to create new DrinkRecipe Objects
 */

@Dependent
public class DrinkService {

    @Inject
    DrinkMenu drinkMenu;

    @Inject
    IngredientCatalog ingredientCatalog;

    @Inject
    isAlcoholicService isAlcoholicService;

    @Inject
    IdProducer idProducer;

    @CircuitBreaker(requestVolumeThreshold = 4)
    public DrinkRecipe getDrinkRecipe(int id) {
        return drinkMenu.getDrinkRecipe(id);
    }

    public Map<Integer, DrinkRecipe> getAllDrinkRecipes() {
        return drinkMenu.getAllDrinkRecipes();
    }

    public DrinkRecipe createDrinkRecipe(String name, List<String> ingredients, String preparation) {
        List<Ingredient> ingredientsList = new ArrayList<>();
        for (String ingredientName : ingredients) {
            if (ingredientCatalog.getIngredient(ingredientName) == null) {
                throw new IllegalArgumentException("Ingredient " + ingredientName + " does not exist");
            } else {
                ingredientsList.add(new Ingredient(ingredientCatalog.getIngredient(ingredientName).getName(), ingredientCatalog.getIngredient(ingredientName).getIsAlcoholic()));
            }
        }
        int id = idProducer.createId();
        DrinkRecipe drinkRecipe = new DrinkRecipe(name, preparation, ingredientsList, id);
        return drinkMenu.saveDrinkRecipe(drinkRecipe);
    }

    public boolean deleteDrinkRecipe(int id) {
        return drinkMenu.deleteDrinkRecipe(id);
    }

    @CircuitBreaker(requestVolumeThreshold = 1)
    public void editDrinkRecipe(int id, String name, List<String> ingredients, String preparation) {
        List<Ingredient> ingredientsList = ingredients.stream().map(ingredientName -> ingredientCatalog.getIngredient(ingredientName)).toList();
        drinkMenu.updateDrinkRecipe(id, name, ingredientsList, preparation);
    }

    public List<DrinkRecipe> getAllCocktailRecipes() {
         return drinkMenu.getAllDrinkRecipes().values().stream().filter(isAlcoholicService::isAlcoholic).toList();

    }

    public List<DrinkRecipe> getAllMocktailRecipes() {
        return drinkMenu.getAllDrinkRecipes().values().stream().filter(drinkRecipe -> !isAlcoholicService.isAlcoholic(drinkRecipe)).toList();
    }
}
