package de.hsos.swa.drink.bl;

import jakarta.enterprise.context.Dependent;
import org.jboss.logging.Logger;

@Dependent
public class isAlcoholicService {

    public boolean isAlcoholic(DrinkRecipe drinkRecipe) {
        return drinkRecipe.getIngredients().stream().anyMatch(Ingredient::getIsAlcoholic);
    }
}
