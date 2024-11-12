package de.hsos.swa.drink.dal;

import de.hsos.swa.drink.bl.DrinkMenu;
import de.hsos.swa.drink.bl.DrinkRecipe;
import de.hsos.swa.drink.bl.Ingredient;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class DrinkRepository implements DrinkMenu {
    private static final Logger logging = Logger.getLogger(DrinkRepository.class);

    private final Map<Integer, DrinkRecipe> drinkRecipes;

    public DrinkRepository() {
        this.drinkRecipes = new HashMap<>();
    }

    @Override
    public DrinkRecipe saveDrinkRecipe(DrinkRecipe drinkRecipe) {
        logging.info("Saving drink recipe");
        this.drinkRecipes.put(drinkRecipe.getId(), drinkRecipe);
        logging.trace("Drink recipe: " + drinkRecipe + ", ID: " + drinkRecipe.getId());
        return drinkRecipe;
    }

    @Override
    public DrinkRecipe getDrinkRecipe(int id) {
        logging.info("Getting drink recipe with id " + id);
        logging.trace("ID: " + id + ", Recipe: " + this.drinkRecipes.get(id));
        return this.drinkRecipes.get(id);
    }

    @Override
    public Map<Integer, DrinkRecipe> getAllDrinkRecipes() {
        logging.info("Getting all drink recipes");
        logging.trace("All drink recipes: " + this.drinkRecipes);
        return this.drinkRecipes;
    }

    @Override
    public boolean deleteDrinkRecipe(int id) {
        logging.info("Deleting drink recipe with id " + id);
        logging.trace("ID: " + id + ", Recipe: " + this.drinkRecipes.get(id));
        return (this.drinkRecipes.remove(id) != null);
    }

    @Override
    public DrinkRecipe updateDrinkRecipe(int id, String name, List<Ingredient> ingredients, String preparation) {
        logging.info("Updating drink recipe with id " + id);
        logging.trace("ID: " + id + ", Name: " + name + ", Ingredients: " + ingredients + ", Preparation: " + preparation);
        this.drinkRecipes.get(id).setName(name);
        this.drinkRecipes.get(id).setIngredients(ingredients);
        this.drinkRecipes.get(id).setPreparation(preparation);
        logging.trace("Updated drink recipe: " + this.drinkRecipes.get(id));
        return this.drinkRecipes.get(id);
    }
}
