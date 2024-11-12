package de.hsos.swa.drink.acl;

import de.hsos.swa.drink.bl.DrinkRecipe;
import de.hsos.swa.drink.bl.Ingredient;
import org.jboss.logging.Logger;

public class DrinkRecipeConverter {
    private static final Logger logging = Logger.getLogger(DrinkRecipeConverter.class);

    public static DrinkRecipeDTO convertToDTO(DrinkRecipe drinkRecipe) {
        logging.info("Converting drink recipe to DTO");
        logging.trace("Drink recipe: " + drinkRecipe);
        logging.trace("DTO: " + new DrinkRecipeDTO(
                drinkRecipe.getName(),
                drinkRecipe.getPreparation(),
                drinkRecipe.getIngredients().stream().map(Ingredient::getName).toList()
        ));
        return new DrinkRecipeDTO(
                drinkRecipe.getName(),
                drinkRecipe.getPreparation(),
                drinkRecipe.getIngredients().stream().map(Ingredient::getName).toList()
        );
    }
}