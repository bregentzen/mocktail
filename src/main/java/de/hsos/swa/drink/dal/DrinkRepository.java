package de.hsos.swa.drink.dal;

import de.hsos.swa.drink.bl.DrinkMenu;
import de.hsos.swa.drink.bl.DrinkRecipe;
import de.hsos.swa.drink.bl.Ingredient;
import de.hsos.swa.shared.Log;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
@Log(Log.Level.TRACE)
public class DrinkRepository implements DrinkMenu {


    private final Map<Integer, DrinkRecipe> drinkRecipes;

    public DrinkRepository() {
        this.drinkRecipes = new HashMap<>();
    }

    @Override
    public DrinkRecipe saveDrinkRecipe(DrinkRecipe drinkRecipe) {

        this.drinkRecipes.put(drinkRecipe.getId(), drinkRecipe);

        return drinkRecipe;
    }

    @Override
    public DrinkRecipe getDrinkRecipe(int id) {

        return this.drinkRecipes.get(id);
    }

    @Override
    public Map<Integer, DrinkRecipe> getAllDrinkRecipes() {

        return this.drinkRecipes;
    }

    @Override
    public boolean deleteDrinkRecipe(int id) {

        return (this.drinkRecipes.remove(id) != null);
    }

    @Override
    public DrinkRecipe updateDrinkRecipe(int id, String name, List<Ingredient> ingredients, String preparation) {

        this.drinkRecipes.get(id).setName(name);
        this.drinkRecipes.get(id).setIngredients(ingredients);
        this.drinkRecipes.get(id).setPreparation(preparation);
        return this.drinkRecipes.get(id);
    }
}
