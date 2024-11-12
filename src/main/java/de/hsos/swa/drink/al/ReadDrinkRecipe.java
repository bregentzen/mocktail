package de.hsos.swa.drink.al;

import de.hsos.swa.drink.acl.DrinkRecipeDTO;

import java.util.List;

public interface ReadDrinkRecipe {
    DrinkRecipeDTO readDrinkRecipe(int id);
    List<DrinkRecipeDTO> readAllDrinkRecipes();
    List<DrinkRecipeDTO> readAllCocktailRecipes();
    List<DrinkRecipeDTO> readAllMocktailRecipes();
}
