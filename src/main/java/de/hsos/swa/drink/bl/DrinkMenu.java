package de.hsos.swa.drink.bl;

import java.util.List;
import java.util.Map;

public interface DrinkMenu {
    DrinkRecipe getDrinkRecipe(int id);
    Map<Integer, DrinkRecipe> getAllDrinkRecipes();
    boolean deleteDrinkRecipe(int id);
    DrinkRecipe updateDrinkRecipe(int id, String name, List<Ingredient> ingredients, String preparation);
    DrinkRecipe saveDrinkRecipe(DrinkRecipe drinkRecipe);
}
