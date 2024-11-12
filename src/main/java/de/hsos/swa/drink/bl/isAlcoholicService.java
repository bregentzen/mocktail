package de.hsos.swa.drink.bl;

import jakarta.enterprise.context.Dependent;
import org.jboss.logging.Logger;

@Dependent
public class isAlcoholicService {
    private static final Logger logging = Logger.getLogger(isAlcoholicService.class);

    public boolean isAlcoholic(DrinkRecipe drinkRecipe) {
        logging.info("Checking if drink is alcoholic");
        logging.trace("Drink: " + drinkRecipe + ", isAlcoholic: " + drinkRecipe.getIngredients().stream().anyMatch(Ingredient::getIsAlcoholic));
        return drinkRecipe.getIngredients().stream().anyMatch(Ingredient::getIsAlcoholic);
    }
}
